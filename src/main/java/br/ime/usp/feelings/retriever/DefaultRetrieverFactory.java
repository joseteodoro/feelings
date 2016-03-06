package br.ime.usp.feelings.retriever;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.retriever.watson.DefaultFeelingsRetriever;

public class DefaultRetrieverFactory implements RetrieverFactory {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}

	@Override
	public FeelingsRetriever setupFeelingsRetriever() {
		return new DefaultFeelingsRetriever();
	}

}
