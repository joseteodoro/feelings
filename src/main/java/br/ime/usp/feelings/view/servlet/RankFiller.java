package br.ime.usp.feelings.view.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.serviceClients.processor.rank.RankItem;
import br.ime.usp.feelings.actor.FeelingsActor;

/**
 * 
 * @author jteodoro
 * 
 *         Layer between servlets and the content processors. Call the Rank
 *         Actor to connect with Bluemix and transform the results to the view.
 */
public class RankFiller {

	public final static String SUBJECT_PARAMETER_NAME = "subject";

	public static final String REDIRECT_DESTINATION = "/rank.jsp";

	public static final String RANK_PARAMETER_NAME = "ranks";

	private final FeelingsActor<RankItem> feelingActor;

	public RankFiller(FeelingsActor<RankItem> feelingActor) {
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
		Collection<RankItem> ranks = getRanks(subject);
		putRanksOnRequest(request, ranks);
		redirectWithRanks(request, response);
	}

	private void redirectWithRanks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(REDIRECT_DESTINATION).forward(request, response);
	}

	private void putRanksOnRequest(HttpServletRequest request, Collection<RankItem> ranks) {
		String subject = request.getParameter(SUBJECT_PARAMETER_NAME);
		request.setAttribute(SUBJECT_PARAMETER_NAME, subject);
		request.setAttribute(RANK_PARAMETER_NAME, ranks);
	}

	private Collection<RankItem> getRanks(String subject) {
		Collection<RankItem> ranks = feelingActor.doProcess(subject);
		return ranks;
	}

}
