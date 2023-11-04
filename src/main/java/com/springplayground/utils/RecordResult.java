package com.springplayground.utils;

import java.util.HashMap;
import java.util.Map;

public class RecordResult {
	private final Map<Long, Record> table = new HashMap<>(500000);
	private Long id = 1L;

	public Long addRecord(Record record) {
		table.put(id, record);
		return id++;
	}

	public Map<Long, Record> getTable() {
		return table;
	}
}
