package br.ime.usp.feelings;

public class RankItens {
	
	private int rank;
	
	private String label;
	
	public RankItens(int rank, String label) {
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
