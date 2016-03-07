package br.ime.usp.feelings.retriever.factory;

import java.util.Collection;

/**
 * 
 * @author jteodoro
 * 
 *         Transforms Strings in <T>.
 *
 * @param <T>
 *            processor result.
 */
public interface ContentProcessor<T> {

	/**
	 * @param content
	 *            messages / posts / news.
	 * @return results after processing the content.
	 */
	Collection<T> doProcess(Collection<String> content);

}
