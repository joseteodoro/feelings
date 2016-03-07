package br.ime.usp.feelings.retriever.content.twitter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
 *         Connect to Twitter and ask about the subject and create our
 *         resultset.
 *         
 * this class uses env vars to connect. You can get this keys in the Twitter developer's
 * site. 
 * 
 * $ export twitter4j.oauth.consumerKey=********************* 
 * $ export twitter4j.oauth.consumerSecret=**************************************
 * $ export twitter4j.oauth.accessToken=*****************************************
 * $ export twitter4j.oauth.accessTokenSecret=***********************************
 */
public class TwitterFinder implements Finder {

	private final Configuration twitterdAuthConfiguration;

	private Twitter twitter;

	private TwitterFactory setupTwitterFactory() {
		if (twitterdAuthConfiguration != null) {
			return new TwitterFactory(twitterdAuthConfiguration);
		}
		return new TwitterFactory();
	}

	public TwitterFinder(Configuration twitterdAuthConfiguration) {
		this.twitterdAuthConfiguration = twitterdAuthConfiguration;
	}

	public TwitterFinder() {
		this.twitterdAuthConfiguration = null;
	}

	/*
	 * Call the method configureConnection() before call this method.
	 * 
	 * Ask Twitter about the subject and create a list with the text messages.
	 * 
	 * @param subject subject to ask twitter
	 * 
	 * @return a collection with the messages.
	 */
	@Override
	public Collection<String> search(String subject) {
		String encoded = this.encodeURIComponent(subject);
		return doSearch(encoded);
	}

	/*
	 * configure the Twitter connection.
	 */
	@Override
	public void configureConnection() {
		TwitterFactory factory = setupTwitterFactory();
		twitter = factory.getInstance();
	}

	private Collection<String> doSearch(String queryString) {
		Query query = new Query(queryString);
		query.setLang("en");
		query.setCount(50);
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

	/**
	 * javascript's like hack
	 * 
	 * @param s
	 *            string to encode
	 * @return encoded string
	 */
	public String encodeURIComponent(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!")
					.replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")")
					.replaceAll("\\%7E", "~");
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}

}
