package br.ime.usp.feelings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.rank.DefaultRankContentFactory;
import br.ime.usp.feelings.rank.RankItem;
import br.ime.usp.feelings.retriever.FeelingsActor;
import br.ime.usp.feelings.retriever.factory.ContentFactory;

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
		// just for local testing
		// factory = new FakeRankItensContentFactory();
		ContentFactory<RankItem> factory;
		factory = new DefaultRankContentFactory();
		FeelingsActor<RankItem> actor = new FeelingsActor<>(factory);
		RankFiller rankFiller = new RankFiller(actor);
		rankFiller.fillAndRedirect(request, response);
	}

}
