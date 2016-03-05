package br.ime.usp.feelings.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingActor;

public class FeelingFiller {
	
	protected final static String SUBJECT_PARAMETER_NAME = "subject";

	protected static final String REDIRECT_DESTINATION = "/feelings.jsp";
	
	private final FeelingActor feelingActor;
	
	public FeelingFiller(FeelingActor feelingActor) {
		this.feelingActor = feelingActor;
	}

	public void fillAndRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter(SUBJECT_PARAMETER_NAME);
		Collection<Feeling> feelings = getFeelings(subject);
		putFeelingsOnRequest(request, feelings);		
		redirectWithFeelings(request, response);
	}
	
	private void redirectWithFeelings(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(REDIRECT_DESTINATION).forward(request,response);
	}

	private void putFeelingsOnRequest(HttpServletRequest request, Collection<Feeling> feelings) {
		feelings.forEach(feeling -> request.setAttribute(feeling.getFeeling().getLabel(), feeling.getScore()));
	}

	private Collection<Feeling> getFeelings(String subject) {
		Collection<Feeling> feelings = feelingActor.getFeelings(subject);
		return feelings;
	}
}
