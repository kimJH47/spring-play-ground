package com.springplayground.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;

public class LocalDateRandomSet implements RandomSet {

	private final LocalDateTime minLocalDate;
	private final LocalDateTime maxLocalDate;

	public LocalDateRandomSet(LocalDateTime min, LocalDateTime max) {
		validate(min, max);
		this.minLocalDate = min;
		this.maxLocalDate = max;

	}

	private void validate(LocalDateTime min, LocalDateTime max) {
		if (max.isBefore(min)) {
			throw new IllegalArgumentException("invalid date range");
		}
	}

	@Override
	public String get() {
		ZoneId zoneId = ZoneId.systemDefault();
		long min = minLocalDate.atZone(zoneId).toInstant().toEpochMilli();
		long max = maxLocalDate.atZone(zoneId).toInstant().toEpochMilli();
		return LocalDateTime.ofInstant(createRandomInstant(min, max), zoneId)
			.toString();
	}

	private Instant createRandomInstant(long min, long max) {
		return Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max));
	}
}
