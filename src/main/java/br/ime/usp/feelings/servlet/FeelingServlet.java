package br.ime.usp.feelings.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingActor;
import br.ime.usp.feelings.retriever.DefaultRetriverFactory;

/**
 * 
 * @author jteodoro
 *
 * servlet to get the feelings about a subject.
 */
public class FeelingServlet extends HttpServlet {
	
	private final static String SUBJECT_PARAMETER_NAME = "subject";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String subject = request.getParameter(SUBJECT_PARAMETER_NAME);
		FeelingActor feelingActor = new FeelingActor(new DefaultRetriverFactory());
		Collection<Feeling> feelings = feelingActor.getFeelings(subject);
		
	}


	
}
