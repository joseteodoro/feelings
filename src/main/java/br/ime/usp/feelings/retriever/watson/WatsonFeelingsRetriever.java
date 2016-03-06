package br.ime.usp.feelings.retriever.watson;

import java.util.Collection;
import java.util.LinkedList;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingEnum;
import br.ime.usp.feelings.retriever.FeelingsRetriever;

public class WatsonFeelingsRetriever implements FeelingsRetriever {
	
	private final WatsonEmotionAdapter adapter;
	
	public WatsonFeelingsRetriever(WatsonEmotionAdapter adapter) {
		super();
		this.adapter = adapter;
	}

	public Collection<Feeling> retrieve(Collection<String> contents) {
		StringBuilder builder = new StringBuilder();
		contents.forEach(content -> builder.append(content).append("\n"));
		AlchemyLanguageEmotionAnswer answer = adapter.callWatson(builder.toString());
		return this.answerToList(answer);
	}
	
	private Collection<Feeling> answerToList(AlchemyLanguageEmotionAnswer answer) {
		LinkedList<Feeling> feelings = new LinkedList<>();
		feelings.add(new Feeling(FeelingEnum.SADNESS, answer.getSadness()));
		feelings.add(new Feeling(FeelingEnum.JOY, answer.getJoy()));
		feelings.add(new Feeling(FeelingEnum.ANGER, answer.getAnger()));
		return feelings;
	}
	
}
