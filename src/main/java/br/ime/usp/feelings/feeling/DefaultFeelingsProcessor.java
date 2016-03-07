package br.ime.usp.feelings.feeling;

import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.watson.WatsonAlchemyEmotionCaller;
import br.ime.usp.feelings.retriever.watson.WatsonEmotionAdapter;
import br.ime.usp.feelings.retriever.watson.WatsonFeelingsRetriever;
import br.ime.usp.feelings.retriever.watson.WatsonRestAlchemyEmotionClient;

/**
 * 
 * @author jteodoro
 *
 * call Watson to evaluate the emotion on the content.
 */
public class DefaultFeelingsProcessor implements ContentProcessor<Feeling> {

	@Override
	public Collection<Feeling> doProcess(Collection<String> content) {
		WatsonAlchemyEmotionCaller caller = new WatsonRestAlchemyEmotionClient();
		WatsonEmotionAdapter adapter = new WatsonEmotionAdapter(caller);
		WatsonFeelingsRetriever watsonFeelingsRetriever = new WatsonFeelingsRetriever(adapter);
		return watsonFeelingsRetriever.doProcess(content);
	}

}
