package br.ime.usp.feelings.retriever.connection;

import br.ime.usp.feelings.serviceClients.retriever.watson.WatsonRestAlchemyEmotionClient;

/**
 * 
 * @author jteodoro
 *
 * just use to test your watson alchemy connection because it has a rquest limit. For this
 * reason, this test are out of build.
 * 
 * DO NOT COMMIT YOUR Alchemy KEY!
 * 
 */
public class WatsonRestAlchemyEmotionClientTest {

	public static void main(String [] args) {
		new WatsonRestAlchemyEmotionClientTest().testConnection();
	}
	
	private void testConnection() {
		WatsonRestAlchemyEmotionClient client = new WatsonRestAlchemyEmotionClient();
		String result = client.call(this.getSubject());
		System.out.println(result);
	}

	private String getSubject() {
		return "MUST HAVE SEO TOOL create UNIQUE articles in seconds! #bloggers #DigitalMarketing Clinton rules "
				+ "Twitter during� https://t.co/GwRrQoBYdU RelNews: "
				+ "Jim Webb: I'd vote for Trump, but not Clinton -The Washington Post- https://t.co/QdpP74MAQV "
				+ "RelNews: Trump \'sexism\' a key target for pro-Clinton advocates, super PACs -ABC News- https://t.co/1W2o3ceyFf "
				+ "Security Logs Show No Signs that Clinton�s Private Server Was Hacked: The FBI has reviewed the security logs f... https://t.co/KlODMCRAB5 "
				+ "RT @Variety: Hillary Clinton to join Bernie Sanders at Fox News town hall https://t.co/eureBosP7t https://t.co/wg84gKKn2p "
				+ "RelNews: Hillary Clinton will appear Monday on Fox News for the first time since 2014 -Los Angeles Times- https://t.co/NqRnIvHkQ9 "
				+ "NotRel:: Donald Trump vs Hillary Clinton, ?�quiA?n ganarA?a la elecciA?n` -CNNExpansi&oacute;n- https://t.co/taWzb82g7f "
				+ "#Expected wins for Clinton, Trump rivals in big Saturday balloting, but will it be enough? #jobs #jobsearch #n... https://t.co/6Gd2AQrFFX "
				+ "#Trump and Clinton each look to strengthen their frontrunner status #jobs #jobsearch #: #REPUBLICAN Donald Tru... https://t.co/B7jg9Ci7R1 "
				+ "RelNews:  Clinton&rsquo;s Email Jeopardy -The Wall Street Journal- https://t.co/e5ZVXJwky3 "
				+ "@DailyCaller The Q he doesn't follow up with: Mrs. Clinton, is it okay to send/receive classified info so long as it's not \"marked\"? "
				+ "RelNews: Trump 'sexism' a key target for pro-Clinton advocates, super PACs -The Washington Post- https://t.co/cJ4HNMX3uR "
				+ "RelNews: Jim Webb: I\\\\\\\'d vote for Trump, but not Clinton -The Washington Post- https://t.co/QdpP74MAQV "
				+ "Clinton, Trump seek to widen leads - https://t.co/BFKrhjSn8u ";

	}

}
