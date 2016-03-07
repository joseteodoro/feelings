package br.ime.usp.feelings.rank;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.IOUtils;

import br.ime.usp.feelings.rank.xml.XmlToRankConverter;
import br.ime.usp.feelings.retriever.factory.ContentFactory;
import br.ime.usp.feelings.retriever.factory.ContentProcessor;
import br.ime.usp.feelings.retriever.factory.ContentRetriever;

/**
 * 
 * @author jteodoro
 * 
 * Factory to get and rank fake contents. Just for local tests.
 */
public class FakeRankItensContentFactory implements ContentFactory<RankItem> {

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
	public ContentProcessor<RankItem> setupProcessor() {
		XmlToRankConverter converter = new XmlToRankConverter();
		String content = this.getContent();
		Collection<RankItem> found = converter.getRanks(content, XmlToRankConverter.EVENT_REGEX, XmlToRankConverter.PEOPLE_REGEX);
		return new ContentProcessor<RankItem>() {
			public Collection<RankItem> doProcess(Collection<String> content) {
				return found;
			}
		};
	}
	
	private String getContent() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("relationResultSample.xml");
		try {
			return IOUtils.toString(resourceAsStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
