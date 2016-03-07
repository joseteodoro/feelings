package br.ime.usp.feelings.serviceClients.retriever.watson;

import org.junit.Assert;
import org.junit.Test;

public class WatsonEmotionAdapterTest {
	
	@Test
	public void adaptAnAnswer() {
		FakeWatsonAlchemyEmotionCaller caller =  new  FakeWatsonAlchemyEmotionCaller();
		String parameter = "whatever";
		WatsonEmotionAdapter adapter = new WatsonEmotionAdapter(caller);
		AlchemyLanguageEmotionAnswer jsonToObject = adapter.callWatson(parameter);
		Assert.assertNotNull(jsonToObject);
		Assert.assertEquals(caller.anger, jsonToObject.getAnger(), 0.0000000001f);
		Assert.assertEquals(caller.disgust, jsonToObject.getDisgust(), 0.0000000001f);
		Assert.assertEquals(caller.fear, jsonToObject.getFear(), 0.0000000001f);
		Assert.assertEquals(caller.joy, jsonToObject.getJoy(), 0.0000000001f);
		Assert.assertEquals(caller.sadness, jsonToObject.getSadness(), 0.0000000001f);
	}
	

}
