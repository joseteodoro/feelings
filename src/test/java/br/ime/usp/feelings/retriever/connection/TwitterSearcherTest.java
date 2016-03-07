package br.ime.usp.feelings.retriever.connection;

import java.util.Collection;

import org.junit.Assert;

import br.ime.usp.feelings.serviceClients.retriever.content.twitter.Finder;
import br.ime.usp.feelings.serviceClients.retriever.content.twitter.TwitterFinder;

/**
 * 
 * @author jteodoro
 * 
 * Use to test your connection and keys provided by Twitter. Twitter has a request limit per minute,
 * so this test does not run on the build.
 * 
 * To run you need to map your twitter oAth. Something like:
 * 
 * $ export twitter4j.oauth.consumerKey=*********************
 * $ export twitter4j.oauth.consumerSecret=******************************************
 * $ export twitter4j.oauth.accessToken=**************************************************
 * $ export twitter4j.oauth.accessTokenSecret=******************************************
 * 
 * DO NOT COMMIT YOUR KEY VALUES!
 */
public class TwitterSearcherTest {
	
	public static void main(String [] args) {
		TwitterSearcherTest twitterSearcherTest = new TwitterSearcherTest();
		twitterSearcherTest.connectAndSearchAndPrint();
	}
	
	private void connectAndSearchAndPrint() {
		Finder twitterSearcher = new TwitterFinder();
		String subject = "Election";
		twitterSearcher.configureConnection();
		Collection<String> results = twitterSearcher.search(subject);
		Assert.assertFalse(results.isEmpty());
		results.forEach(result -> System.out.println(result));
	}
	
}
