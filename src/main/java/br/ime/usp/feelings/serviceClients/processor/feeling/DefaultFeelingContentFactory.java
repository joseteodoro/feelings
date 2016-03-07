package br.ime.usp.feelings.serviceClients.processor.feeling;

import br.ime.usp.feelings.serviceClients.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.serviceClients.factory.ContentFactory;
import br.ime.usp.feelings.serviceClients.factory.ContentProcessor;
import br.ime.usp.feelings.serviceClients.factory.ContentRetriever;

/**
 * 
 * @author jteodoro
 *
 * Default factory to connect Twitter and evaluate its content using Watson.
 */
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
