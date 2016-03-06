package br.ime.usp.feelings.retriever.watson;

import java.util.Collection;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.retriever.FeelingsRetriever;

public class DefaultFeelingsRetriever implements FeelingsRetriever {

	@Override
	public Collection<Feeling> retrieve(Collection<String> content) {
		WatsonAlchemyEmotionCaller caller = new WatsonRestAlchemyEmotionClient();
		WatsonEmotionAdapter adapter = new WatsonEmotionAdapter(caller);
		WatsonFeelingsRetriever watsonFeelingsRetriever = new WatsonFeelingsRetriever(adapter);
		return watsonFeelingsRetriever.retrieve(content);
	}

}
