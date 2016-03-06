package br.ime.usp.feelings.servlet;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.ContentFactory;
import br.ime.usp.feelings.ContentProcessor;
import br.ime.usp.feelings.RankItens;
import br.ime.usp.feelings.retriever.ContentRetriever;
import br.ime.usp.feelings.retriever.FakeRetrieverFactory;

public class FakeRankItensContentFactory implements ContentFactory<RankItens> {

	@Override
	public ContentRetriever setupContentRetriever() {
		return new FakeRetrieverFactory().setupContentRetriever();
	}

	@Override
	public ContentProcessor<RankItens> setupProcessor() {
		return new ContentProcessor<RankItens>() {
			public Collection<RankItens> doProcess(Collection<String> content) {
				return Arrays.asList(new RankItens(1, "One"),new RankItens(2, "Two"),
						new RankItens(3, "Three"));
			}
		};
	}

}
