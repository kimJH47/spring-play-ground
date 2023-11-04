package com.springplayground.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextRandomSet implements RandomSet {

	private static final int SET_PREFIX = 0;
	private final List<String> values;

	public TextRandomSet(List<String> values) {
		this.values = new ArrayList<>(values);
	}

	@Override
	public String get() {
		Collections.shuffle(values);
		return values.get(SET_PREFIX);
	}
}
