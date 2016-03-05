package br.ime.usp.feelings.retriever.twitter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ime.usp.feelings.retriever.RetrieveException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

/**
 * 
 * @author jteodoro
 *
 * Ask Twitter about the subject and create our resultset.
 */
public class TwitterSearcher {

	private final Configuration twitterdAuthConfiguration;

	public TwitterSearcher(Configuration twitterdAuthConfiguration) {
		this.twitterdAuthConfiguration = twitterdAuthConfiguration;
	}
	
	public TwitterSearcher() {
		this.twitterdAuthConfiguration = null;
	}

	public Collection<String> search(String subject) {
		String queryString = String.format("q=%s", subject);
		Collection<String> results = configureAndSearch(queryString);
		return results;
	}

	private Collection<String> configureAndSearch(String queryString) {
		TwitterFactory factory = setupTwitterFactory();
		Query query = new Query(queryString);
		Twitter twitter = factory.getInstance();
		Collection<String> results = doSearch(queryString, query, twitter);
		return results;
	}

	private Collection<String> doSearch(String queryString, Query query, Twitter twitter) {
		QueryResult result;
		Collection<String> results = new HashSet<String>();
		try {
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					results.add(tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
		} catch (TwitterException tex) {
			String messageError = String.format("Error getting data from Twitter. Query: [%s].", queryString);
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageError, tex);
			throw new RetrieveException(messageError, tex);
		}
		return results;
	}

	private TwitterFactory setupTwitterFactory() {
		if (twitterdAuthConfiguration!=null) {
		return new TwitterFactory(twitterdAuthConfiguration);
		}
		/*
		 * constructor using env vars:
		 * $ export twitter4j.oauth.consumerKey=*********************
		 * $ export twitter4j.oauth.consumerSecret=******************************************
		 * $ export twitter4j.oauth.accessToken=**************************************************
		 * $ export twitter4j.oauth.accessTokenSecret=******************************************
		 */
		return new TwitterFactory();
	}

}
