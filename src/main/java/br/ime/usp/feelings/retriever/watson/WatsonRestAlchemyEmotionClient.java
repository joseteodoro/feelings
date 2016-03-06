package br.ime.usp.feelings.retriever.watson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import br.ime.usp.feelings.retriever.RetrieveException;

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
public class WatsonRestAlchemyEmotionClient implements WatsonAlchemyEmotionCaller {

	private static final int SUCCESS_CODE = 200;
	
	private static final String WATSON_ALCHEMY_API_KEY = "watson.alchemy.api.key";
	
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

	private HttpPost createRestJsonRequest(String subject) {
		HttpPost postRequest = new HttpPost("http://gateway-a.watsonplatform.net/calls/text/TextGetEmotion");
		postRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");

		Collection<BasicNameValuePair> parameters = new LinkedList<>();
		parameters.add(new BasicNameValuePair("apikey", System.getProperty(WATSON_ALCHEMY_API_KEY)));
		parameters.add(new BasicNameValuePair("text", subject));
		parameters.add(new BasicNameValuePair("outputMode", "json"));

		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters);
		postRequest.setEntity(urlEncodedFormEntity);
		return postRequest;
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
