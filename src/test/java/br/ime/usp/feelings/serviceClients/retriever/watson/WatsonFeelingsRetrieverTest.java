package br.ime.usp.feelings.serviceClients.retriever.watson;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.serviceClients.retriever.watson.AlchemyLanguageEmotionAnswer;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonEmotionAdapter;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonFeelingsRetriever;
import org.junit.Test;
import org.mockito.Mockito;

import br.ime.usp.feelings.serviceClients.processor.feeling.Feeling;
import br.ime.usp.feelings.serviceClients.processor.feeling.FeelingEnum;
import junit.framework.Assert;

public class WatsonFeelingsRetrieverTest {
	
	@Test
	public void retrieve() {
		Collection<String> contents = Arrays.asList("a", "b", "c");
		WatsonEmotionAdapter adapter = Mockito.mock(WatsonEmotionAdapter.class);
		AlchemyLanguageEmotionAnswer expectedValue = new AlchemyLanguageEmotionAnswer();
		expectedValue.setAnger(1f);
		expectedValue.setDisgust(2f);
		expectedValue.setFear(3f);
		expectedValue.setJoy(4f);
		expectedValue.setSadness(5f);
		Mockito.when(adapter.callWatson(Mockito.anyString())).thenReturn(expectedValue);
		WatsonFeelingsRetriever retriever = new WatsonFeelingsRetriever(adapter);
		Collection<Feeling> found = retriever.doProcess(contents);
		Assert.assertNotNull(found);
		Assert.assertFalse(found.isEmpty());
		Assert.assertTrue(found.contains(new Feeling(FeelingEnum.ANGER, expectedValue.getAnger())));
		Assert.assertTrue(found.contains(new Feeling(FeelingEnum.JOY, expectedValue.getJoy())));
		Assert.assertTrue(found.contains(new Feeling(FeelingEnum.SADNESS, expectedValue.getSadness())));
	}

}
