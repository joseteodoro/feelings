package br.ime.usp.feelings.rank.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import br.ime.usp.feelings.rank.RankItem;

public class XmlToRankConverterTest {

	
	@Test
	public void readAXml() throws IOException {
		XmlToRankConverter converter = new XmlToRankConverter();
		String content = this.getContent();
		Collection<RankItem> found = converter.getRanks(content);
		Assert.assertNotNull(found);
		Assert.assertFalse(found.isEmpty());
		Assert.assertEquals("Presidential election", found.iterator().next().getLabel());
	}

	private String getContent() throws IOException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("relationResultSample.xml");
		return IOUtils.toString(resourceAsStream);
	}
	
}
