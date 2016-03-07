package br.ime.usp.feelings.serviceClients.retriever.relationExtraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import br.ime.usp.feelings.serviceClients.factory.RetrieveException;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonAlchemyEmotionCaller;

/**
 * 
 * @author jteodoro
 *
 *         This is a simple client to Watson Alchemy Emotion REST. It uses an
 *         envVar called "watson.alchemy.api.key" to get your API KEY. Be sure
 *         it is declared in your enviroment before call the watson.
 * 
 * 
 */
public abstract class AbstractRestBluemixClient implements WatsonAlchemyEmotionCaller {

	private static final int SUCCESS_CODE = 200;

	/**
	 * Call Watson / Bluemix to evaluate the content.
	 * 
	 * @param subject
	 *            data to send in the watson's request.
	 */
	public String call(String subject) {
		try {
			HttpPost postRequest = createRestJsonRequest(subject);
			HttpResponse response = doRequest(postRequest);
			return responseToString(response);
		} catch (IOException ioex) {
			String messageError = "Error getting data from Watson.";
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageError, ioex);
			throw new RetrieveException(messageError, ioex);
		}
	}

	/**
	 * Configure the request to Watson / Bluemix services.
	 * 
	 * @param subject
	 *            data to send in the watson's request.
	 * @return the watson/bluemix request to send by httpClient.
	 */
	protected abstract HttpPost createRestJsonRequest(String subject);

	private HttpResponse doRequest(HttpPost postRequest) throws IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = httpClient.execute(postRequest);
		if (response.getStatusLine().getStatusCode() != SUCCESS_CODE) {
			String errorMessage = "Failed : HTTP error code : " + response.getStatusLine().getStatusCode();
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, errorMessage);
			throw new RetrieveException(errorMessage);
		}
		return response;
	}

	private String responseToString(HttpResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String responseContent = IOUtils.toString(br);
		if (!responseContent.contains("OK")) {
			String errorMessage = "Failed getting data from Watson. Response: " + responseContent;
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, errorMessage);
			throw new RetrieveException(errorMessage);
		}
		return responseContent;
	}

}
