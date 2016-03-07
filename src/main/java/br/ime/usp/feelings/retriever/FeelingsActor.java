package br.ime.usp.feelings.retriever;

import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

/**
 * 
 * @author jteodoro
 *
 * Actor to get content about the subject and
 * send that to the content processor.
 * 
 * @param <TARGET> processor's target.
 */
public class FeelingsActor<TARGET> {
	
	private final ContentFactory<TARGET> factory;
	
	public FeelingsActor(ContentFactory<TARGET> factory) {
		this.factory = factory;
	}
	
	/**
	 * Get the data about the subject and send it to processor.
	 * 
	 * @param subject to get the content.
	 * @return values from processor.
	 */
	public Collection<TARGET> doProcess(String subject) {
		ContentRetriever contentRetriever = factory.setupContentRetriever();
		ContentProcessor<TARGET> processor = factory.setupProcessor();
		Collection<String> content = contentRetriever.retrieve(subject);
		Collection<TARGET> ranks = processor.doProcess(content);
		return ranks;
	}
	
}
