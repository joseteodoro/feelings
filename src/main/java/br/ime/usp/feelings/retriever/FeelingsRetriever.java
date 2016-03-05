package br.ime.usp.feelings.retriever;

import java.util.Collection;

import br.ime.usp.feelings.Feeling;

public interface FeelingsRetriever {
	
	Collection<Feeling> retrieve(Collection<String> content);
	
}
