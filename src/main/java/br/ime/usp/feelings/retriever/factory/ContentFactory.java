package br.ime.usp.feelings.retriever.factory;

/**
 * 
 * @author jteodoro
 * 
 *         Content factory to retrieve and process content.
 * @param <T>
 *            content target
 */
public interface ContentFactory<T> {

	/**
	 * @return content retriever.
	 */
	ContentRetriever setupContentRetriever();

	/**
	 * @return content processor to transform the strings in <T>
	 */
	ContentProcessor<T> setupProcessor();

}