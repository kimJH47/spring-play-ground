package com.springplayground.utils;

public class Record {

	private final String value;

	public Record(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
