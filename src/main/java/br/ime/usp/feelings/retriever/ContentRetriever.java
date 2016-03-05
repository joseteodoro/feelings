package br.ime.usp.feelings.retriever;

import java.util.Collection;

public interface ContentRetriever {
	
	public Collection<String> retrieve(String subject);

}
