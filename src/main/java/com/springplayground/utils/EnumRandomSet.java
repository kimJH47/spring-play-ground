package com.springplayground.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnumRandomSet<E extends Enum<E>> implements RandomSet {

	private final List<E> values;

	public EnumRandomSet(Class<E> type) {
		E[] enumConstants = type.getEnumConstants();
		values = Arrays.asList(enumConstants);
	}

	@Override
	public String get() {
		Collections.shuffle(values);
		return values.get(0).toString();
	}
}