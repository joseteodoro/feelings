package br.ime.usp.feelings.rank;

import java.util.Collection;

import br.ime.usp.feelings.rank.xml.XmlToRankConverter;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.relationExtraction.WatsonRestRelationExtractionClient;

public class DefaultRankProcessor implements ContentProcessor<RankItem> {

	private final WatsonRestRelationExtractionClient restClient;
	
	private final XmlToRankConverter converter;
	
	public DefaultRankProcessor() {
		this(new WatsonRestRelationExtractionClient(), new XmlToRankConverter());
	}
	
	public DefaultRankProcessor(WatsonRestRelationExtractionClient restClient, XmlToRankConverter converter) {
		this.restClient = restClient;
		this.converter = converter;
	}

	@Override
	public Collection<RankItem> doProcess(Collection<String> contents) {
		String subject = joinContent(contents);
		String watsonResult = requestWatson(subject);
		Collection<RankItem> foundRanks = watsonResultsToRankItens(watsonResult);
		return foundRanks;
	}

	private Collection<RankItem> watsonResultsToRankItens(String watsonResult) {
		Collection<RankItem> foundRanks = converter.getRanks(watsonResult, XmlToRankConverter.PEOPLE_REGEX, XmlToRankConverter.EVENT_REGEX);
		return foundRanks;
	}

	private String requestWatson(String subject) {
		String watsonResult = restClient.call(subject);
		return watsonResult;
	}

	private String joinContent(Collection<String> contents) {
		StringBuilder builder = new StringBuilder();
		contents.forEach(content -> builder.append(content).append("\n"));
		String subject = builder.toString();
		return subject;
	}

}
