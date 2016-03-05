package br.ime.usp.feelings.retriever.watson;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ime.usp.feelings.retriever.RetrieveException;

public class WatsonEmotionAdapter {

	private final WatsonAlchemyEmotionCaller caller;
	
	public WatsonEmotionAdapter(WatsonAlchemyEmotionCaller caller) {
		this.caller = caller;
	}

	public AlchemyLanguageEmotionAnswer callWatson(String parameter) {
		String json = this.caller.call(parameter);
		String cleanedJson = this.removeResultStatus(json);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			AlchemyLanguageEmotionAnswer readValue = objectMapper.readValue(cleanedJson, AlchemyLanguageEmotionAnswer.class);
			return readValue;
		} catch (IOException ioex) {
			String messageError = String.format("Error reading data from JSON response. JSON: [%s].", json);
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageError, ioex);
			throw new RetrieveException(messageError, ioex);
		}
	}

	private String removeResultStatus(String json) {
		return new EmotionJSONCleaner().clean(json);
	}
	
}
