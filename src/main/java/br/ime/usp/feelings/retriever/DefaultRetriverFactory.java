package br.ime.usp.feelings.retriever;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;

public class DefaultRetriverFactory {
	
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}
	
	public FeelingsRetriever setupFeelingsRetriever() {
		return null;
	}
	
	public RankRetriever setupRankRetriever() {
		return null;
	}

}
