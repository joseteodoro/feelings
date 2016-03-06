package br.ime.usp.feelings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ime.usp.feelings.ContentFactory;
import br.ime.usp.feelings.FeelingActor;
import br.ime.usp.feelings.FeelingsActor;
import br.ime.usp.feelings.RankItens;
import br.ime.usp.feelings.retriever.FakeRetrieverFactory;
import br.ime.usp.feelings.retriever.RetrieverFactory;

/**
 * Created by jteodoro on 04/03/16.
 */
public class RankServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// just for local testing
		 ContentFactory<RankItens> factory = new FakeRankItensContentFactory();
//		RetrieverFactory factory = new DefaultRankItensContentFactory();
		FeelingsActor<RankItens> actor = new FeelingsActor<>(factory);
		RankFiller rankFiller = new RankFiller(actor);
		rankFiller.fillAndRedirect(request, response);
	}
	
}
