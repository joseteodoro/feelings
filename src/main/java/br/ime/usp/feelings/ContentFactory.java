package br.ime.usp.feelings;

import br.ime.usp.feelings.retriever.ContentRetriever;

public interface ContentFactory<T> {

	ContentRetriever setupContentRetriever();

	ContentProcessor<T> setupProcessor();

}