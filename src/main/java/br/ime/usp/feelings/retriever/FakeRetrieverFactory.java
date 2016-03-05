package br.ime.usp.feelings.retriever;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import br.ime.usp.feelings.Feeling;
import br.ime.usp.feelings.FeelingEnum;

public class FakeRetrieverFactory implements RetrieverFactory {

	@Override
	public ContentRetriever setupContentRetriever() {
		// return new DefaultContentRetriever();
		return new ContentRetriever() {
			@Override
			public Collection<String> retrieve(String subject) {
				return Arrays.asList("a", "b", "c");
			}
		};
	}

	@Override
	public FeelingsRetriever setupFeelingsRetriever() {
		return new FeelingsRetriever() {
			@Override
			public Collection<Feeling> retrieve(Collection<String> content) {
				List<Feeling> fls = new LinkedList<>();

				for (FeelingEnum selectd : FeelingEnum.values()) {
					fls.add(new Feeling(selectd, (float) Math.random()));
				}
				return fls;
			}
		};
	}

	@Override
	public RankRetriever setupRankRetriever() {
		return null;
	}

}