package com.springplayground.utils;

import java.util.concurrent.ThreadLocalRandom;

public class NumberRandomSet implements RandomSet {

	private final long min;
	private final long max;

	public NumberRandomSet(long min, long max) {
		validate(min, max);
		this.min = min;
		this.max = max;
	}

	private void validate(long min, long max) {
		if (min > max) {
			throw new IllegalArgumentException("invalid number range");
		}
	}

	@Override
	public String get() {
		return String.valueOf(ThreadLocalRandom.current()
			.nextLong(min, max));
	}
}
