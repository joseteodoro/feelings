package br.ime.usp.feelings.servlet;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingActor;
import br.ime.usp.feelings.FeelingEnum;
import br.ime.usp.feelings.retriever.ContentRetriever;
import br.ime.usp.feelings.retriever.DefaultRetrieverFactory;
import br.ime.usp.feelings.retriever.FeelingsRetriever;
import br.ime.usp.feelings.retriever.RetrieverFactory;

public class FeelingActorTest {
	
	@Test
	public void getContentAndAskForFelling() {
		String subject = "subject";
		Collection<String> content = Arrays.asList("content");
		Collection<Feeling> feelings = Arrays.asList(new Feeling(FeelingEnum.JOY, 0.5f));
		RetrieverFactory factory = setupFactory(subject, content, feelings);
		FeelingActor feelingActor = new FeelingActor(factory);
		Collection<Feeling> feelingsResult = feelingActor.getFeelings(subject);
		Assert.assertSame(feelings, feelingsResult);
	}

	private RetrieverFactory setupFactory(String subject, Collection<String> content,
			Collection<Feeling> feelings) {
		ContentRetriever contentRetriever = Mockito.mock(ContentRetriever.class);
		Mockito.when(contentRetriever.retrieve(subject)).thenReturn(content);
		FeelingsRetriever feelingsRetriever = Mockito.mock(FeelingsRetriever.class);
		Mockito.when(feelingsRetriever.retrieve(content)).thenReturn(feelings);
		RetrieverFactory factory = Mockito.mock(RetrieverFactory.class);
		Mockito.when(factory.setupContentRetriever()).thenReturn(contentRetriever);
		Mockito.when(factory.setupFeelingsRetriever()).thenReturn(feelingsRetriever);
		return factory;
	}

}
