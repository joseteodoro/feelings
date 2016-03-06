package br.ime.usp.feelings.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import br.ime.usp.feelings.rank.RankItem;
import br.ime.usp.feelings.retriever.FeelingsActor;

public class RankFillerTest {
	
	@Test
	public void fillAndRedirectARequest() throws ServletException, IOException {
		String subject = "subject";
		RankItem rank = new RankItem(1, "rank");
		Collection<RankItem> ranks = Arrays.asList(rank);
		FeelingsActor<RankItem> feelingActor = setupActor(subject, ranks);
		HttpServletRequest request = setupRequest(subject);
		RankFiller feelingFiller = new RankFiller(feelingActor);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

		feelingFiller.fillAndRedirect(request, response);
		Mockito.verify(request).getParameter(RankFiller.SUBJECT_PARAMETER_NAME);
		Mockito.verify(request).setAttribute(rank.getLabel(), rank);
		Mockito.verify(request).getRequestDispatcher(RankFiller.REDIRECT_DESTINATION);
	}

	private FeelingsActor<RankItem> setupActor(String subject, Collection<RankItem> ranks) {
		FeelingsActor<RankItem> actor = Mockito.mock(FeelingsActor.class);
		Mockito.when(actor.doProcess(subject)).thenReturn(ranks);
		return actor;
	}

	private HttpServletRequest setupRequest(String parameterValue) {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		Mockito.when(request.getParameter(RankFiller.SUBJECT_PARAMETER_NAME)).thenReturn(parameterValue);
		RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
		Mockito.when(request.getRequestDispatcher(RankFiller.REDIRECT_DESTINATION)).thenReturn(dispatcher);
		return request;
	}

}
