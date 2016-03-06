package br.ime.usp.feelings.retriever.factory;

import java.util.Collection;

public interface ContentRetriever {
	
	public Collection<String> retrieve(String subject);

}
