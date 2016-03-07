package br.ime.usp.feelings.serviceClients.processor.rank.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import br.ime.usp.feelings.serviceClients.processor.rank.xml.XmlToRankConverter;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import br.ime.usp.feelings.serviceClients.processor.rank.RankItem;

public class XmlToRankConverterTest {

	@Test
	public void readAXml() throws IOException {
		XmlToRankConverter converter = new XmlToRankConverter();
		String content = this.getContent();
		Collection<RankItem> found = converter.getRanks(content, XmlToRankConverter.EVENT_REGEX, XmlToRankConverter.PEOPLE_REGEX);
		Assert.assertNotNull(found);
		Assert.assertFalse(found.isEmpty());
		Assert.assertEquals(22,found.size());
		Assert.assertNotNull(found.iterator().next().getLabel());
		Assert.assertFalse(found.iterator().next().getLabel().isEmpty());
	}

	private String getContent() throws IOException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("relationResultSample.xml");
		return IOUtils.toString(resourceAsStream);
	}
	
}
