package br.ime.usp.feelings.retriever.content.twitter;

import java.util.Collection;

import br.ime.usp.feelings.retriever.ContentRetriever;

public class DefaultContentRetriever implements ContentRetriever {

	private final Finder searcher;
	
	public DefaultContentRetriever() {
		this(new TwitterFinder());
	}
	
	public DefaultContentRetriever(Finder searcher) {
		this.searcher = searcher;
	}

	public Collection<String> retrieve(String subject) {
		searcher.configureConnection();
		return searcher.search(subject);
	}

}
