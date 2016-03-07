package br.ime.usp.feelings.serviceClients.processor.rank;

/**
 * 
 * @author jteodoro
 *
 * Word evaluated by BlueMix Relation Extraction and 
 * wieghted by its ocurrency.
 */
public class RankItem {
	
	private int rank;
	
	private String label;
	
	public RankItem(int rank, String label) {
		super();
		this.rank = rank;
		this.label = label;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
