package br.ime.usp.feelings.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.FeelingsActor;
import br.ime.usp.feelings.RankItens;

public class RankFiller {
	
	protected final static String SUBJECT_PARAMETER_NAME = "subject";

	protected static final String REDIRECT_DESTINATION = "/rank.jsp";
	
	private final FeelingsActor<RankItens> feelingActor;
	
	public RankFiller(FeelingsActor<RankItens> feelingActor) {
		this.feelingActor = feelingActor;
	}

	public void fillAndRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter(SUBJECT_PARAMETER_NAME);
		Collection<RankItens> ranks = getFeelings(subject);
		putRanksOnRequest(request, ranks);
		redirectWithRanks(request, response);
	}
	
	private void redirectWithRanks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(REDIRECT_DESTINATION).forward(request,response);
	}

	private void putRanksOnRequest(HttpServletRequest request, Collection<RankItens> ranks) {
		ranks.forEach(rank -> request.setAttribute(rank.getLabel(), rank));
	}

	private Collection<RankItens> getFeelings(String subject) {
		Collection<RankItens> ranks = feelingActor.doProcess(subject);
		return ranks;
	}

}
