package br.ime.usp.feelings.retriever.connection;

import br.ime.usp.feelings.retriever.relationExtraction.WatsonRestRelationExtractionClient;

public class WatsonRestRelationExtractionClientTest {

	public static void main(String [] args) {
		new WatsonRestRelationExtractionClientTest().testConnection();
	}
	
	private void testConnection() {
		WatsonRestRelationExtractionClient client = new WatsonRestRelationExtractionClient();
		String result = client.call(this.getSubject());
		System.out.println(result);
	}

	private String getSubject() {
		return "RT @BikinInMaine: MT @TeriGRight: It's not JUST any Presidential election! #TCOT #2A https://t.co/X4JuVwGQzT #CruzCrew #PJNET"+
"RT @astroehlein: Fico's xenophobic rhetoric didn't help him: He lost his majority & extreme right will enter Slovak parliament https://t.co…"+
"@MrAyeDee him saying e can afford his kids school fees jst reminded me dt Buhari is a complete liar, during d election e claimed to be poor"+
"Exactly one of these actually matters to me in this election. ( https://t.co/LiyHhc1Say ; https://t.co/0SNpDxGUxJ ) https://t.co/fsiiGS8zKZ"+
"@KiryowaKk We are answering every claim in the petition filed by @AmamaMbabazi. As far as we are concerned, the election was fair @ugandarn"+
"Cruz, have you even looked at the swing states for the gen election? You have no chance! Drop out now so we can can beat Hillary."+
"RT @AshakaSaleh: Former NSA Sambo Dasuki & his friends praying to God for Jonathan to WIN the 2015 election . #throwback3015elections https…"+
"Big kudos to election workers - Corpus Christi Caller https://t.co/lZIu1cxuWh"+
"After #GE16, where next for Ireland, an tOireachtas and the diaspora abroad? My thoughts since the election.  https://t.co/zzToz69AX1"+
"@MRVChennai mr. Kk the next pm candidate for 2019 election for Congress will b able to guide us thru poverty, capitalism,  corruption"+
"RT @AtusiubaOkwy: @inecnigeria If u don't cancel Bende LGA election in #AbiaNorthRerun, it means that Nigerians has to be prepared cos we a…"+
"Flint becomes U.S. Democratic flash point, but residents want action  https://t.co/uUS1J98ptF"+
"Abia North senatorial re-run election inconclusive, INEC says https://t.co/0xgZ6uED7k";
	}
	
}
