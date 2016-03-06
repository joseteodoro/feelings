package br.ime.usp.feelings.feeling;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class FakeFeelingContentFactory implements ContentFactory<Feeling> {

	@Override
	public ContentRetriever setupContentRetriever() {
		// mocking an interned delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ContentRetriever() {
			@Override
			public Collection<String> retrieve(String subject) {
				return Arrays.asList("a", "b", "c");
			}
		};
	}

	@Override
	public ContentProcessor<Feeling> setupProcessor() {
		return new ContentProcessor<Feeling>() {
			
			@Override
			public Collection<Feeling> doProcess(Collection<String> content) {
				return Arrays.asList(new Feeling(FeelingEnum.SADNESS, (float) Math.random()),
						new Feeling(FeelingEnum.JOY, (float) Math.random()),
								new Feeling(FeelingEnum.ANGER, (float) Math.random()));
			}
		};
	}

}
