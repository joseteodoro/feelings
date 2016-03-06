package br.ime.usp.feelings.retriever;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.retriever.watson.DefaultFeelingsRetriever;
import br.ime.usp.feelings.retriever.watson.WatsonAlchemyEmotionCaller;
import br.ime.usp.feelings.retriever.watson.WatsonEmotionAdapter;
import br.ime.usp.feelings.retriever.watson.WatsonFeelingsRetriever;
import br.ime.usp.feelings.retriever.watson.WatsonRestAlchemyEmotionClient;

public class DefaultRetrieverFactory implements RetrieverFactory {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}

	@Override
	public FeelingsRetriever setupFeelingsRetriever() {
		return new DefaultFeelingsRetriever();
	}

	@Override
	public RankRetriever setupRankRetriever() {
		return null;
	}

}
