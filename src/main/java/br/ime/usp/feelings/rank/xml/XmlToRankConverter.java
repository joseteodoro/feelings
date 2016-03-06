package br.ime.usp.feelings.rank.xml;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ime.usp.feelings.rank.RankItem;

public class XmlToRankConverter {

	public static final String EVENT_REGEX = "(<mention).*(etype=\"EVENT).*(mention>)";
	
	public static final String PEOPLE_REGEX = "(<mention).*(etype=\"PERSON).*(mention>)";

	private static final String REGEX_CONTENT = "(>).*(<)";
	
	public Collection<RankItem> getRanks(String content, String ... targetRegexes) {
		Collection<RankItem> ranks = new LinkedList<>();
		for (String regex : targetRegexes) {
			Collection<RankItem> itens = getWeightedItensForRegex(content, regex);
			ranks.addAll(itens);
		}
		return ranks;
	}

	private Collection<RankItem> getWeightedItensForRegex(String content, String regex) {
		Matcher eventMatcher = getMatcherForRegex(content, regex);
		Map<String, Integer> ratio = getValuesAndRatio(eventMatcher);
		Collection<RankItem> itens = convertItensToRankItens(ratio);
		return itens;
	}

	private Matcher getMatcherForRegex(String content, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher eventMatcher = pattern.matcher(content);
		return eventMatcher;
	}


	private Collection<RankItem> convertItensToRankItens(Map<String, Integer> ratio) {
		Collection<RankItem> itens = new LinkedList<>();
		ratio.forEach((key, value) -> itens.add(new RankItem(value, key)));
		return itens;
	}


	private Map<String, Integer> getValuesAndRatio(Matcher matcher) {
		Map<String, Integer> ratio = new HashMap<>();
		Pattern contentPattern = Pattern.compile(REGEX_CONTENT);
		while (matcher.find()) {
			String mentionTag = matcher.group();
			Matcher contentMatcher = contentPattern.matcher(mentionTag);
			if (contentMatcher.find()) {
				String tagValue = getTagValue(contentMatcher);
				incrementRatio(ratio, tagValue);
			}
		}
		return ratio;
	}

	private String getTagValue(Matcher contentMatcher) {
		return contentMatcher.group().replaceAll("[><]", "");
	}

	private void incrementRatio(Map<String, Integer> ratio, String tagValue) {
		if (!ratio.containsKey(tagValue)) {
			ratio.put(tagValue, Integer.valueOf(0));
		}
		ratio.put(tagValue, ratio.get(tagValue) + 1);
	}
	
}
