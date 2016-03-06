package br.ime.usp.feelings.retriever;

import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class FeelingsActor<TARGET> {
	
	private final ContentFactory<TARGET> factory;
	
	public FeelingsActor(ContentFactory<TARGET> factory) {
		this.factory = factory;
	}
	
	public Collection<TARGET> doProcess(String subject) {
		ContentRetriever contentRetriever = factory.setupContentRetriever();
		ContentProcessor<TARGET> processor = factory.setupProcessor();
		Collection<String> content = contentRetriever.retrieve(subject);
		Collection<TARGET> ranks = processor.doProcess(content);
		return ranks;
	}
	
}
