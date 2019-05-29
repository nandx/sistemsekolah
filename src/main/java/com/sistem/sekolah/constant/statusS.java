package com.sistem.sekolah.constant;

public enum statusS {
	PENDING("PENDING"), SENT("SENT"), DRAFT("DRAFT");

	private statusS(String text) {
		this.text = text;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
