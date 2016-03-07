package br.ime.usp.feelings.serviceClients.retriever.watson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlchemyRestAnswer {

	private AlchemyLanguageEmotionAnswer docEmotions;

	public AlchemyLanguageEmotionAnswer getDocEmotions() {
		return docEmotions;
	}

	public void setDocEmotions(AlchemyLanguageEmotionAnswer docEmotions) {
		this.docEmotions = docEmotions;
	}
	
}
