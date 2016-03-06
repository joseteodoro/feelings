package br.ime.usp.feelings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.feeling.DefaultFeelingContentFactory;
import br.ime.usp.feelings.feeling.FakeFeelingContentFactory;
import br.ime.usp.feelings.feeling.Feeling;
import br.ime.usp.feelings.retriever.FeelingsActor;
import br.ime.usp.feelings.retriever.factory.ContentFactory;

/**
 * 
 * @author jteodoro
 *
 *         servlet to get the feelings about a subject.
 */
public class FeelingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// just for local testing
		ContentFactory<Feeling> factory;
		factory = new DefaultFeelingContentFactory();
		factory = new FakeFeelingContentFactory();
		FeelingsActor<Feeling> actor = new FeelingsActor<>(factory);
		FeelingFiller feelingFiller = new FeelingFiller(actor);
		feelingFiller.fillAndRedirect(request, response);
	}

}
