package br.ime.usp.feelings.retriever.relationExtraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import br.ime.usp.feelings.retriever.RetrieveException;
import br.ime.usp.feelings.retriever.watson.WatsonAlchemyEmotionCaller;

/**
 * 
 * @author jteodoro
 *
 * This is a simple client to Watson Alchemy Emotion REST. 
 * It uses an envVar called "watson.alchemy.api.key" to get your API KEY. Be sure it is 
 * declared in your enviroment before call the watson.
 * 
 * 
 */
public abstract class AbstractRestBluemixClient implements WatsonAlchemyEmotionCaller {

	private static final int SUCCESS_CODE = 200;
	
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

	private HttpResponse doRequest(HttpPost postRequest) throws IOException{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = httpClient.execute(postRequest);
		if (response.getStatusLine().getStatusCode() != SUCCESS_CODE) {
			String errorMessage = "Failed : HTTP error code : " + response.getStatusLine().getStatusCode();
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, errorMessage);
			throw new RetrieveException(errorMessage);
		}
		return response;
	}

	protected abstract HttpPost createRestJsonRequest(String subject);
	
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
