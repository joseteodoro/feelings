package br.ime.usp.feelings.serviceClients.retriever.content.twitter;

import java.util.Collection;

//TODO (jteodoro 2016-03-06) consider remove this.
public interface Finder {

	/*
	 * Call the method configureConnection() before call this method.
	 * 
	 * Ask Twitter about the subject and create a list with the text messages.
	 * 
	 * @param subject subject to ask twitter
	 * 
	 * @return a collection with the messages.
	 */
	Collection<String> search(String subject);

	/*
	 * configure a connection for this Finder.
	 */
	void configureConnection();

}