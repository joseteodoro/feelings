package br.ime.usp.feelings;

import java.util.Collection;

import br.ime.usp.feelings.retriever.ContentRetriever;
import br.ime.usp.feelings.retriever.FeelingsRetriever;
import br.ime.usp.feelings.retriever.RetrieverFactory;

public class FeelingActor {
	
	private final RetrieverFactory factory;
	
	public FeelingActor(RetrieverFactory factory) {
		this.factory = factory;
	}
	
	public Collection<Feeling> getFeelings(String subject) {
		ContentRetriever contentRetriever = factory.setupContentRetriever();
		FeelingsRetriever feelingsRetriever = factory.setupFeelingsRetriever();
		Collection<String> content = contentRetriever.retrieve(subject);
		Collection<Feeling> feelings = feelingsRetriever.retrieve(content);
		return feelings;
	}
}
