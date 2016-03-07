package br.ime.usp.feelings.serviceClients.retriever.watson;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ime.usp.feelings.serviceClients.factory.RetrieveException;

public class WatsonEmotionAdapter {

	private final WatsonAlchemyEmotionCaller caller;
	
	public WatsonEmotionAdapter(WatsonAlchemyEmotionCaller caller) {
		this.caller = caller;
	}

	public AlchemyLanguageEmotionAnswer callWatson(String parameter) {
		String json = this.caller.call(parameter);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			AlchemyLanguageEmotionAnswer readValue = objectMapper.readValue(json, AlchemyRestAnswer.class).getDocEmotions();
			return readValue;
		} catch (Exception ioex) {
			String messageError = String.format("Error reading data from JSON response. JSON: [%s].", json);
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageError, ioex);
			throw new RetrieveException(messageError, ioex);
		}
	}
	
}
