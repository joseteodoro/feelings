package br.ime.usp.feelings.retriever;

import java.util.Collection;

public interface FeelingsRetriever {
	
	Collection<String> retrieve(String subject);
	
}
