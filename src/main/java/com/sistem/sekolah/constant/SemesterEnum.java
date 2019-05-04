package com.sistem.sekolah.constant;

public enum SemesterEnum {
	GANJIL(1), GENAP(2);

	private SemesterEnum(Integer text) {
		this.text = text;
	}

	private Integer text;

	public Integer getText() {
		return text;
	}

	public void setText(Integer text) {
		this.text = text;
	}
}
