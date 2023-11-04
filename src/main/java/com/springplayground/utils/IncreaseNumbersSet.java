package com.springplayground.utils;

public class IncreaseNumbersSet implements DataSet {
	private final int prefix;
	private Integer value;

	public IncreaseNumbersSet(int prefix, int value) {
		this.prefix = prefix;
		this.value = value;
	}

	@Override
	public String get() {
		String str = String.valueOf(value + prefix);
		value++;
		return str;
	}

}
