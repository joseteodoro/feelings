package br.ime.usp.feelings.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.feeling.Feeling;
import br.ime.usp.feelings.retriever.FeelingsActor;

/**
 * 
 * @author jteodoro
 * 
 *         Layer between servlets and the content processors. Call the Feelings
 *         Actor to connect with Watson and transform the results to the view.
 */
public class FeelingFiller {

	protected final static String SUBJECT_PARAMETER_NAME = "subject";

	protected static final String REDIRECT_DESTINATION = "/feelings.jsp";

	private final FeelingsActor<Feeling> feelingActor;

	public FeelingFiller(FeelingsActor<Feeling> feelingActor) {
		this.feelingActor = feelingActor;
	}

	/**
	 * Call processor's results and fill the request before redirect to the jsp.
	 * 
	 * @param request
	 *            .
	 * @param response
	 *            .
	 * @throws ServletException
	 *             .
	 * @throws IOException
	 *             .
	 */
	public void fillAndRedirect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subject = request.getParameter(SUBJECT_PARAMETER_NAME);
		request.setAttribute(SUBJECT_PARAMETER_NAME, subject);
		Collection<Feeling> feelings = getFeelings(subject);
		putFeelingsOnRequest(request, feelings);
		redirectWithFeelings(request, response);
	}

	private void redirectWithFeelings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(REDIRECT_DESTINATION).forward(request, response);
	}

	private void putFeelingsOnRequest(HttpServletRequest request, Collection<Feeling> feelings) {
		feelings.forEach(feeling -> request.setAttribute(feeling.getFeeling().getLabel(), feeling));
	}

	private Collection<Feeling> getFeelings(String subject) {
		Collection<Feeling> feelings = feelingActor.doProcess(subject);
		return feelings;
	}
}
