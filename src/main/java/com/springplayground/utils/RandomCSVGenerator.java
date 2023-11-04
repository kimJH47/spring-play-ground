package com.springplayground.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RandomCSVGenerator {

	@SafeVarargs
	public final void createCSV(List<String> headers, int rowCount, int idPrefix,
		LocalDateTime minDate, LocalDateTime maxDate, Long price,
		List<String>... args) {

		File file = new File("/Users/kim/Desktop/PRODUCT.csv");
		StringBuilder stringBuilder = new StringBuilder();

		List<List<String>> attributes = new ArrayList<>(Arrays.asList(args));
		appendHeaders(headers, stringBuilder);

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < rowCount; i++) {
				stringBuilder.append(createPrimaryKey(i + idPrefix)).append(",")
					.append(createAttribute(attributes))
					.append(",");
				long randomPrice = ThreadLocalRandom.current().nextLong(1000, price);
				stringBuilder.append(randomPrice - randomPrice % 10);
				stringBuilder.append(",")
					.append(createRandomDateTime(minDate, maxDate))
					.append(",")
					.append(createRandomDateTime(minDate, maxDate))
					.append("\n");

			}
			log.debug(stringBuilder.toString());
			bufferedWriter.write(stringBuilder.toString());
		} catch (IOException e) {
			log.debug(e.getMessage());
		}
	}

	private void appendHeaders(List<String> headers, StringBuilder stringBuilder) {
		stringBuilder.append(String.join(",", headers))
			.append("\n");
	}

	private String createAttribute(List<List<String>> attributes) {
		return attributes.stream()
			.map(dataSet -> {
				Collections.shuffle(dataSet);
				return dataSet.get(0);
			})
			.collect(Collectors.joining(","));
	}

	private int createPrimaryKey(int primaryKey) {
		return primaryKey;
	}

	private LocalDateTime createRandomDateTime(LocalDateTime minLocalDate, LocalDateTime maxLocalDate) {
		if (maxLocalDate.isBefore(minLocalDate)) {
			throw new IllegalArgumentException("date ");
		}
		ZoneId zoneId = ZoneId.systemDefault();
		long min = minLocalDate.atZone(zoneId).toInstant().toEpochMilli();
		long max = maxLocalDate.atZone(zoneId).toInstant().toEpochMilli();
		return LocalDateTime.ofInstant(createRandomInstant(min, max), zoneId);
	}

	private Instant createRandomInstant(long min, long max) {
		return Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max));
	}
}
