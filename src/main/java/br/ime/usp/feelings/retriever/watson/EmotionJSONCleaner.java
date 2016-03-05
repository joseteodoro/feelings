package br.ime.usp.feelings.retriever.watson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmotionJSONCleaner {

	private Pattern pattern = Pattern.compile("(\"docEmotions\"\\: \\{).*(\\})");
	
	public String clean(String json) {
		//must exists a better way to do this!
		Matcher matcher = pattern.matcher(json);
		if (matcher.find()) {
			String cleaned = matcher.group().replaceAll("(\"docEmotions\"\\: \\{)", "{");
			cleaned = cleaned.replaceAll("(\\}).*(\\})", "}");
			return cleaned;
		}
		return json;
	}
	
}
