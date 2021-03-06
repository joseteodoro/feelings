package br.ime.usp.feelings.serviceClients.retriever.watson;

import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonAlchemyEmotionCaller;

public class FakeWatsonAlchemyEmotionCaller implements WatsonAlchemyEmotionCaller {

	protected float anger = 0.67753f;
	protected float disgust = 0.048157f;
	protected float fear = 0.024823f;
	protected float joy = 0.042753f;
	protected float sadness = 0.006994f;
	
	@Override
	public String call(String parameter) {
		return "{ \"status\": \"OK\", \"usage\": \""
				+ "By accessing AlchemyAPI or using information generated by AlchemyAPI, "
				+ "you are agreeing to be bound by the AlchemyAPI Terms of Use: "
				+ "http://www.alchemyapi.com/company/terms.html\", \"totalTransactions\": \"0\", "+
				"\"language\": \"english\", \"docEmotions\": "
				+ "{ \"anger\": \"0.67753\", \"disgust\": \"0.048157\", \"fear\":"
				+ " \"0.024823\", \"joy\": \"0.042753\", \"sadness\": \"0.006994\" } }";
	}

}
