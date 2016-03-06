package br.ime.usp.feelings.retriever.factory;

import java.util.Collection;

public interface ContentProcessor<T> {

	Collection<T> doProcess(Collection<String> content);

}
