package br.ime.usp.feelings.serviceClients.processor.feeling;

import java.util.Collection;

import br.ime.usp.feelings.serviceClients.factory.ContentProcessor;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonAlchemyEmotionCaller;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonEmotionAdapter;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonFeelingsRetriever;
import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonRestAlchemyEmotionClient;

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
