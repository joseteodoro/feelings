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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feeling == null) ? 0 : feeling.hashCode());
		result = prime * result + Float.floatToIntBits(score);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feeling other = (Feeling) obj;
		if (feeling != other.feeling)
			return false;
		if (Float.floatToIntBits(score) != Float.floatToIntBits(other.score))
			return false;
		return true;
	}
	
	
}
