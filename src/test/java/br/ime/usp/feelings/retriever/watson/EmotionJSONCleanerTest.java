package br.ime.usp.feelings.retriever.watson;

import org.junit.Assert;
import org.junit.Test;

public class EmotionJSONCleanerTest {

	@Test
	public void clean(){
		String json =  "{ \"status\": \"OK\", \"usage\": \""
				+ "By accessing AlchemyAPI or using information generated by AlchemyAPI, "
				+ "you are agreeing to be bound by the AlchemyAPI Terms of Use: "
				+ "http://www.alchemyapi.com/company/terms.html\", \"totalTransactions\": \"0\", "+
				"language\": \"english\", \"docEmotions\": "
				+ "{ \"anger\": \"0.67753\", \"disgust\": \"0.048157\", \"fear\":"
				+ " \"0.024823\", \"joy\": \"0.042753\", \"sadness\": \"0.006994\" } }";
		EmotionJSONCleaner cleaner = new EmotionJSONCleaner();
		String cleanedJson = cleaner.clean(json);
		String expected = "{ \"anger\": \"0.67753\", \"disgust\": \"0.048157\", \"fear\":"
				+ " \"0.024823\", \"joy\": \"0.042753\", \"sadness\": \"0.006994\" }";
		System.out.println(cleanedJson);
		Assert.assertEquals(expected, cleanedJson);
		
	}
	
}
