package br.ime.usp.feelings.serviceClients.processor.rank;

import br.ime.usp.feelings.serviceClients.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.serviceClients.factory.ContentFactory;
import br.ime.usp.feelings.serviceClients.factory.ContentProcessor;
import br.ime.usp.feelings.serviceClients.factory.ContentRetriever;

/**
 * 
 * @author jteodoro
 * 
 * Default factory to get and rank the content using Bluemix Relation Extraction Service.
 */
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
