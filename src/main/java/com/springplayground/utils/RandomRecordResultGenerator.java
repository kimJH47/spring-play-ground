package com.springplayground.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomRecordResultGenerator implements RecordResultGenerator {

	private Map<String, DataSet> randomSetMap = new LinkedHashMap<>();

	//특정 인터페이스를 구현하는 데이터 셋들을 매개변수로 받음, 그 셋을 통해서 랜덤한 값 하나를 제공 받을 수 있게 함
	public RecordResult generator(int count, List<String> headers, DataSet... variables) {
		List<DataSet> cases = Arrays.asList(variables);
		validateHeaderCount(headers, cases);

		int headerIdx = 0;
		for (DataSet dataSet : cases) {
			randomSetMap.put(headers.get(headerIdx++), dataSet);
		}
		return createRecordResult(count);
	}

	private RecordResult createRecordResult(int count) {
		RecordResult recordResult = new RecordResult();
		for (int i = 0; i < count; i++) {
			Record record = createRecord();
			recordResult.addRecord(record);
		}
		return recordResult;
	}

	private Record createRecord() {
		String record = randomSetMap.values()
			.stream()
			.map(DataSet::get)
			.collect(Collectors.joining(","));
		return new Record(record);
	}

	private void validateHeaderCount(List<String> headers, List<DataSet> cases) {
		if (headers.size() != cases.size()) {
			throw new IllegalArgumentException("The number of headers and columns do not match");
		}
	}
}
