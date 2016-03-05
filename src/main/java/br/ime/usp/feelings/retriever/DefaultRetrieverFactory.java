package br.ime.usp.feelings.retriever;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;

public class DefaultRetrieverFactory implements RetrieverFactory {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}

	@Override
	public FeelingsRetriever setupFeelingsRetriever() {
		return null;
	}

	@Override
	public RankRetriever setupRankRetriever() {
		return null;
	}

}
