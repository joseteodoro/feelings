package br.ime.usp.feelings;

import java.util.Collection;

public interface ContentProcessor<T> {

	Collection<T> doProcess(Collection<String> content);

}
