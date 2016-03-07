package br.ime.usp.feelings.view.servlet;

import br.ime.usp.feelings.actor.FeelingsActor;
import br.ime.usp.feelings.serviceClients.factory.ContentFactory;
import br.ime.usp.feelings.serviceClients.processor.rank.DefaultRankContentFactory;
import br.ime.usp.feelings.serviceClients.processor.rank.RankItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jteodoro on 04/03/16.
 * 
 * Resolves the request to Rank the content and build the tagCloud.
 * 
 */
public class RankServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContentFactory<RankItem> factory;
		factory = new DefaultRankContentFactory();
		// just for local testing
		//factory = new FakeRankItensContentFactory();
		FeelingsActor<RankItem> actor = new FeelingsActor<>(factory);
		RankFiller rankFiller = new RankFiller(actor);
		rankFiller.fillAndRedirect(request, response);
	}

}
