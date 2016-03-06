package br.ime.usp.feelings.feeling;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class FakeRetrieverFactory implements ContentFactory<Feeling> {

	@Override
	public ContentRetriever setupContentRetriever() {
		//mocking an internet delay
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
				List<Feeling> fls = new LinkedList<>();

				for (FeelingEnum selectd : FeelingEnum.values()) {
					fls.add(new Feeling(selectd, (float) Math.random()));
				}
				return fls;
			}
		};
	}

}
