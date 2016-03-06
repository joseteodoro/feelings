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
public class WatsonRestRelationExtractionClient implements WatsonAlchemyEmotionCaller {

	private static final int SUCCESS_CODE = 200;
	
	private static final String WATSON_RELATION_EXTRACTION_SERVICE_URL = "watson.relation.extraction.service";
	
	private static final String WATSON_RELATION_EXTRACTION_USER_NAME = "watson.relation.extraction.user";
	
	private static final String WATSON_RELATION_EXTRACTION_PASS = "watson.relation.extraction.pass";
	
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
		String serviceUrl = System.getProperty(WATSON_RELATION_EXTRACTION_SERVICE_URL);
		HttpPost postRequest = new HttpPost(serviceUrl);
		postRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
		String auth = String.format("%s:%s", System.getProperty(WATSON_RELATION_EXTRACTION_USER_NAME),System.getProperty(WATSON_RELATION_EXTRACTION_PASS));
		String authorization = String.format("Basic %s", Base64.encodeBase64String(auth.getBytes()));
		postRequest.addHeader("Authorization", authorization);
		
		Collection<BasicNameValuePair> parameters = new LinkedList<>();
		parameters.add(new BasicNameValuePair("sid", "ie-en-news"));
		parameters.add(new BasicNameValuePair("txt", subject));
		parameters.add(new BasicNameValuePair("rt", "xml"));

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
