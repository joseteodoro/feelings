package br.ime.usp.feelings.serviceClients.processor.rank.xml;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ime.usp.feelings.serviceClients.processor.rank.RankItem;

/**
 * 
 * @author jteodoro
 *
 * Converter between XML (Relation Extraction Bluemix Service result) 
 * and RankItens. This code is using REGEX to get only
 * EVENT and PERSON tags. Just for simplicity.
 * 
 */
public class XmlToRankConverter {

	public static final String EVENT_REGEX = "(<mention).*(etype=\"EVENT).*(mention>)";
	
	public static final String PEOPLE_REGEX = "(<mention).*(etype=\"PERSON).*(mention>)";

	private static final String REGEX_CONTENT = "(>).*(<)";
	
	/**
	 * translate the content to RankItens.
	 * 
	 * @param content content received from Relation Extraction Bluemix Service (XML).
	 * 
	 * @param targetRegexes regex to consider when extracting the tag values.
	 * @return
	 */
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
		return this.getTop30(itens);
	}

	private Collection<RankItem> getTop30(Collection<RankItem> itens) {
		List<RankItem> sortedItens = new ArrayList<>(itens);
		Comparator<? super RankItem> comparator = this.setupComparator();
		sortedItens.sort(comparator);
		int cutPoint = sortedItens.size() > 30 ? 30 : sortedItens.size();
		return sortedItens.subList(0, cutPoint) ;
	}

	private Comparator<? super RankItem> setupComparator() {
		return new Comparator<RankItem>() {
			@Override
			public int compare(RankItem o1, RankItem o2) {
				return Integer.compare(o2.getRank(), o1.getRank());
			}
		};
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
