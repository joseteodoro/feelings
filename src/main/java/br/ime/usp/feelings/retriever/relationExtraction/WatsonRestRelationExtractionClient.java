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
public class WatsonRestRelationExtractionClient extends AbstractRestBluemixClient {

	private static final String WATSON_RELATION_EXTRACTION_SERVICE_URL = "watson.relation.extraction.service";
	
	private static final String WATSON_RELATION_EXTRACTION_USER_NAME = "watson.relation.extraction.user";
	
	private static final String WATSON_RELATION_EXTRACTION_PASS = "watson.relation.extraction.pass";
	
	@Override
	protected HttpPost createRestJsonRequest(String subject) {
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

}
