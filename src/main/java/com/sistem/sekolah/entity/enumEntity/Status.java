package com.sistem.sekolah.entity.enumEntity;

public enum Status {
	AKTIF("aktif"), NONAKTIF("nonaktif");

	private Status(String text) {
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
