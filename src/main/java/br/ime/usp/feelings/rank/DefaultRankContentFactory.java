package br.ime.usp.feelings.rank;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class DefaultRankContentFactory implements ContentFactory<RankItem> {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}

	@Override
	public ContentProcessor<RankItem> setupProcessor() {
		return new DefaultRankProcessor();
	}

}