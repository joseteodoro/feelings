package br.ime.usp.feelings.retriever;

/**
 * 
 * @author jteodoro
 *
 * something get wrong retrieving the data.
 */
public class RetrieveException extends RuntimeException {

	public RetrieveException(String message, Throwable reason) {
		super(message, reason);
	}

	public RetrieveException(String errorMessage) {
		super(errorMessage);
	}
	
}
