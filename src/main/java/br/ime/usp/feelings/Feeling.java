package br.ime.usp.feelings;

public class Feeling {

	private FeelingEnum feeling;
	
	private float score;
	
	public Feeling(FeelingEnum feeling, float score) {
		super();
		this.feeling = feeling;
		this.score = score;
	}

	public FeelingEnum getFeeling() {
		return feeling;
	}

	public void setFeeling(FeelingEnum feeling) {
		this.feeling = feeling;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public float scaleToShow() {
		return score*100f+1;
	}
	
}
