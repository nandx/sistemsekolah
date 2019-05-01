package com.sistem.sekolah.entity.enumEntity;

public enum Semester {
	GANJIL(1), GENAP(2);

	private Semester(Integer text) {
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
