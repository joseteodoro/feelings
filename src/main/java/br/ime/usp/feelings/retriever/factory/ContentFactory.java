package br.ime.usp.feelings.retriever.factory;

public interface ContentFactory<T> {

	ContentRetriever setupContentRetriever();

	ContentProcessor<T> setupProcessor();

}