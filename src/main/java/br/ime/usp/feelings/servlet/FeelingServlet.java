package br.ime.usp.feelings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.FeelingActor;
import br.ime.usp.feelings.retriever.DefaultRetrieverFactory;
import br.ime.usp.feelings.retriever.RetrieverFactory;

/**
 * 
 * @author jteodoro
 *
 * servlet to get the feelings about a subject.
 */
public class FeelingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// just for local testing
		// RetrieverFactory factory = new FakeRetrieverFactory();
		RetrieverFactory factory = new DefaultRetrieverFactory();
		FeelingActor actor = new FeelingActor(factory);
		FeelingFiller feelingFiller = new FeelingFiller(actor);
		feelingFiller.fillAndRedirect(request, response);
	}
	
}
