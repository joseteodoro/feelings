package br.ime.usp.feelings;

public enum FeelingEnum {

	ANGER("Anger"), DISGUST("Disgust"), FEAR("Fear"), JOY("Joy"), SADNESS("Sadness");
	
	private final String label;

	private FeelingEnum(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
