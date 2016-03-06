package br.ime.usp.feelings.rank;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.feeling.FakeRetrieverFactory;
import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

public class FakeRankItensContentFactory implements ContentFactory<RankItem> {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new FakeRetrieverFactory().setupContentRetriever();
	}

	@Override
	public ContentProcessor<RankItem> setupProcessor() {
		return new ContentProcessor<RankItem>() {
			public Collection<RankItem> doProcess(Collection<String> content) {
				return Arrays.asList(new RankItem(1, "One"),new RankItem(2, "Two"),
						new RankItem(3, "Three"));
			}
		};
	}

}
