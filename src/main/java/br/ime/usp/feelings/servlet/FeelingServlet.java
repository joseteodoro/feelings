package br.ime.usp.feelings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.feeling.DefaultFeelingContentFactory;
import br.ime.usp.feelings.feeling.Feeling;
import br.ime.usp.feelings.retriever.FeelingsActor;
import br.ime.usp.feelings.retriever.factory.ContentFactory;

/**
 * 
 * @author jteodoro
 *
 *         Resolves the request to evaluate the feelings about content and build
 *         the feeling page.
 */
public class FeelingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// just for local testing
		// factory = new FakeFeelingContentFactory();
		ContentFactory<Feeling> factory;
		factory = new DefaultFeelingContentFactory();
		FeelingsActor<Feeling> actor = new FeelingsActor<>(factory);
		FeelingFiller feelingFiller = new FeelingFiller(actor);
		feelingFiller.fillAndRedirect(request, response);
	}

}
