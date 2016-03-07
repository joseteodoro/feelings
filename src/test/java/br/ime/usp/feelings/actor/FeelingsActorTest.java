package br.ime.usp.feelings.actor;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.actor.FeelingsActor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.ime.usp.feelings.serviceClients.processor.feeling.Feeling;
import br.ime.usp.feelings.serviceClients.processor.feeling.FeelingEnum;
import br.ime.usp.feelings.serviceClients.factory.ContentFactory;
import br.ime.usp.feelings.serviceClients.factory.ContentProcessor;
import br.ime.usp.feelings.serviceClients.factory.ContentRetriever;

public class FeelingsActorTest {
	
	@Test
	public void getContentAndAskForFelling() {
		String subject = "subject";
		Collection<String> content = Arrays.asList("content");
		Collection<Feeling> feelings = Arrays.asList(new Feeling(FeelingEnum.JOY, 0.5f));
		ContentFactory<Feeling> factory = setupFactory(subject, content, feelings);
		FeelingsActor<Feeling> feelingActor = new FeelingsActor<>(factory);
		Collection<Feeling> feelingsResult = feelingActor.doProcess(subject);
		Assert.assertSame(feelings, feelingsResult);
	}

	private ContentFactory<Feeling> setupFactory(String subject, Collection<String> content,
			Collection<Feeling> feelings) {
		ContentRetriever contentRetriever = Mockito.mock(ContentRetriever.class);
		Mockito.when(contentRetriever.retrieve(subject)).thenReturn(content);
		ContentProcessor<Feeling> feelingsRetriever = Mockito.mock(ContentProcessor.class);
		Mockito.when(feelingsRetriever.doProcess(content)).thenReturn(feelings);
		ContentFactory<Feeling> factory = Mockito.mock(ContentFactory.class);
		Mockito.when(factory.setupContentRetriever()).thenReturn(contentRetriever);
		Mockito.when(factory.setupProcessor()).thenReturn(feelingsRetriever);
		return factory;
	}

}
