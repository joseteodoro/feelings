package br.ime.usp.feelings.retriever;

public interface RetrieverFactory {

	ContentRetriever setupContentRetriever();

	FeelingsRetriever setupFeelingsRetriever();

}