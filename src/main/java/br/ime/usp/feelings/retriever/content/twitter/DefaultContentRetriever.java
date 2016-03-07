package br.ime.usp.feelings.retriever.content.twitter;

import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentRetriever;

/**
 * 
 * @author jteodoro
 * 
 * Default content retriever to Twitter.
 * 
 */
//TODO (jteodoro 2016-03-06) consider remove this.
public class DefaultContentRetriever implements ContentRetriever {

	private final Finder searcher;
	
	public DefaultContentRetriever() {
		this(new TwitterFinder());
	}
	
	public DefaultContentRetriever(Finder searcher) {
		this.searcher = searcher;
	}

	/*
	 * (non-Javadoc)
	 * @see br.ime.usp.feelings.retriever.factory.ContentRetriever#retrieve(java.lang.String)
	 */
	public Collection<String> retrieve(String subject) {
		searcher.configureConnection();
		return searcher.search(subject);
	}

}
