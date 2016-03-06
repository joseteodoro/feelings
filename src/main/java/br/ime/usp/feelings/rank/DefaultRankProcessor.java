package br.ime.usp.feelings.rank;

import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.relationExtraction.WatsonRestRelationExtractionClient;
import br.ime.usp.feelings.retriever.watson.AlchemyLanguageEmotionAnswer;

public class DefaultRankProcessor implements ContentProcessor<RankItem> {

	@Override
	public Collection<RankItem> doProcess(Collection<String> contents) {
		StringBuilder builder = new StringBuilder();
		contents.forEach(content -> builder.append(content).append("\n"));
		String subject = builder.toString();
		WatsonRestRelationExtractionClient restClient = new WatsonRestRelationExtractionClient();
		String watsonResult = restClient.call(subject);
		
		return null;
	}

}
