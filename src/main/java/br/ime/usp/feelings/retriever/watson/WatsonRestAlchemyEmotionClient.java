package br.ime.usp.feelings.retriever.watson;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import br.ime.usp.feelings.retriever.relationExtraction.AbstractRestBluemixClient;

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
public class WatsonRestAlchemyEmotionClient extends AbstractRestBluemixClient {

	private static final String WATSON_ALCHEMY_API_KEY = "watson.alchemy.api.key";
	
	@Override
	protected HttpPost createRestJsonRequest(String subject) {
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

}
