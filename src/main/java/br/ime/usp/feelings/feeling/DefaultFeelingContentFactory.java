package br.ime.usp.feelings.feeling;

import br.ime.usp.feelings.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class DefaultFeelingContentFactory implements ContentFactory<Feeling> {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new DefaultContentRetriever();
	}

	@Override
	public ContentProcessor<Feeling> setupProcessor() {
		return new DefaultFeelingsProcessor();
	}

}
