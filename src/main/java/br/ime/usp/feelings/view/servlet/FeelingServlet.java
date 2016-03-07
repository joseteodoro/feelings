package br.ime.usp.feelings.view.servlet;

import br.ime.usp.feelings.actor.FeelingsActor;
import br.ime.usp.feelings.serviceClients.factory.ContentFactory;
import br.ime.usp.feelings.serviceClients.processor.feeling.DefaultFeelingContentFactory;
import br.ime.usp.feelings.serviceClients.processor.feeling.FakeFeelingContentFactory;
import br.ime.usp.feelings.serviceClients.processor.feeling.Feeling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		ContentFactory<Feeling> factory;
		factory = new DefaultFeelingContentFactory();
		// just for local testing
		//factory = new FakeFeelingContentFactory();
		FeelingsActor<Feeling> actor = new FeelingsActor<>(factory);
		FeelingFiller feelingFiller = new FeelingFiller(actor);
		feelingFiller.fillAndRedirect(request, response);
	}

}
