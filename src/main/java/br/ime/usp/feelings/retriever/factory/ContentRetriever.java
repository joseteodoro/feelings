package br.ime.usp.feelings.retriever.factory;

import java.util.Collection;

/**
 * 
 * @author jteodoro
 * 
 *         Content feeder. Connects to another services like Twitter and
 *         Facebook to get their content.
 */
public interface ContentRetriever {

	/**
	 * 
	 * @param subject
	 *            subject to seach the content
	 * @return a collection with messages / posts / news.
	 */
	public Collection<String> retrieve(String subject);

}
