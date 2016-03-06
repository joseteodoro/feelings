package br.ime.usp.feelings.retriever.connection;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ime.usp.feelings.retriever.content.twitter.Finder;
import br.ime.usp.feelings.retriever.content.twitter.TwitterFinder;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

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
		String subject = "clinton";
		twitterSearcher.configureConnection();
		Collection<String> results = twitterSearcher.search(subject);
		Assert.assertFalse(results.isEmpty());
		results.forEach(result -> System.out.println(result));
	}
	
}
