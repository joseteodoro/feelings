package br.ime.usp.feelings.rank.xml;

import java.util.Arrays;
import java.util.Collection;

import br.ime.usp.feelings.rank.RankItem;

public class XmlToRankConverter {

	public Collection<RankItem> getRanks(String content) {
		return Arrays.asList(new RankItem(0, ""));
	}
	
}
