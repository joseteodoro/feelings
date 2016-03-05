package br.ime.usp.feelings.retriever;

import java.util.Collection;

import br.ime.usp.feelings.retriever.twitter.TwitterSearcher;

public class TwitterFeelingsRetriever implements FeelingsRetriever {

	private final TwitterSearcher searcher;
	
	public TwitterFeelingsRetriever() {
		this(new TwitterSearcher());
	}
	
	public TwitterFeelingsRetriever(TwitterSearcher searcher) {
		this.searcher = searcher;
	}

	public Collection<String> retrieve(String subject) {
		return searcher.search(subject);
	}

}
