package br.ime.usp.feelings.serviceClients.retriever.twitter;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.serviceClients.retriever.content.twitter.DefaultContentRetriever;
import br.ime.usp.feelings.serviceClients.retriever.content.twitter.Finder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultContentRetrieverTest {

	@Test
	public void configureBeforeCall() {
		String subject = "MySubject";
		String found = "found";
		Finder finder = Mockito.mock(Finder.class);
		Mockito.when(finder.search(subject)).thenReturn(Arrays.asList(found));
		DefaultContentRetriever contentRetriever = new DefaultContentRetriever(finder);
		Collection<String> results = contentRetriever.retrieve(subject);
		Mockito.verify(finder).configureConnection();
		Mockito.verify(finder).search(subject);
		Assert.assertFalse(results.isEmpty());
		Assert.assertEquals(found, results.iterator().next());
	}

}
