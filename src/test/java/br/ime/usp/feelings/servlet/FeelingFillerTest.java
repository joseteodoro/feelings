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

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingActor;
import br.ime.usp.feelings.FeelingEnum;

public class FeelingFillerTest {
	
	@Test
	public void fillAndRedirectARequest() throws ServletException, IOException {
		String subject = "subject";
		Feeling feeling = new Feeling(FeelingEnum.JOY, 0.5f);
		Collection<Feeling> feelings = Arrays.asList(feeling);
		FeelingActor feelingActor = setupActor(subject, feelings);
		HttpServletRequest request = setupRequest(subject);
		FeelingFiller feelingFiller = new FeelingFiller(feelingActor);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

		feelingFiller.fillAndRedirect(request, response);
		Mockito.verify(request).getParameter(FeelingFiller.SUBJECT_PARAMETER_NAME);
		Mockito.verify(request).setAttribute(FeelingEnum.JOY.getLabel(), feeling);
		Mockito.verify(request).getRequestDispatcher(FeelingFiller.REDIRECT_DESTINATION);
	}

	private FeelingActor setupActor(String subject, Collection<Feeling> feelings) {
		FeelingActor feelingActor = Mockito.mock(FeelingActor.class);
		Mockito.when(feelingActor.getFeelings(subject)).thenReturn(feelings);
		return feelingActor;
	}

	private HttpServletRequest setupRequest(String parameterValue) {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		Mockito.when(request.getParameter(FeelingFiller.SUBJECT_PARAMETER_NAME)).thenReturn(parameterValue);
		RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
		Mockito.when(request.getRequestDispatcher(FeelingFiller.REDIRECT_DESTINATION)).thenReturn(dispatcher);
		return request;
	}

}
