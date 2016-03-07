package br.ime.usp.feelings.serviceClients.processor.rank;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.serviceClients.processor.rank.DefaultRankProcessor;
import br.ime.usp.feelings.serviceClients.processor.rank.RankItem;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.ime.usp.feelings.serviceClients.processor.rank.xml.XmlToRankConverter;
import br.ime.usp.feelings.serviceClients.retriever.relationExtraction.WatsonRestRelationExtractionClient;

public class DefaultRankProcessorTest {

	@Test
	public void doProcess() {		
		Collection<String> contents = Arrays.asList("1","2","3");
		Collection<RankItem> expectedContents = Arrays.asList(new RankItem(0, "label"));
		String watsonResult = "watsonResult";

		WatsonRestRelationExtractionClient restClient = setupRestClient(watsonResult);
		XmlToRankConverter converter = setupConverter(expectedContents, watsonResult);

		DefaultRankProcessor processor = new DefaultRankProcessor(restClient, converter);
		Collection<RankItem> results = processor.doProcess(contents);
		Assert.assertSame(expectedContents, results);
	}

	private WatsonRestRelationExtractionClient setupRestClient(String watsonResult) {
		WatsonRestRelationExtractionClient restClient = Mockito.mock(WatsonRestRelationExtractionClient.class);
		Mockito.when(restClient.call(Mockito.anyString())).thenReturn(watsonResult);
		return restClient;
	}

	private XmlToRankConverter setupConverter(Collection<RankItem> expectedContents, String watsonResult) {
		XmlToRankConverter converter = Mockito.mock(XmlToRankConverter.class);
		Mockito.when(converter.getRanks(watsonResult, XmlToRankConverter.PEOPLE_REGEX,XmlToRankConverter.EVENT_REGEX)).thenReturn(expectedContents);
		return converter;
	}
	
}
