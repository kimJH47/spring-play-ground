package com.springplayground.repo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSortCondition {
	PRICE_LOW("price_low"), PRICE_HIGH("price_high"),
	NEW("new");

	private final String value;

	public static ProductSortCondition createWithSortQuery(String queryString) {
		try {
			return ProductSortCondition.valueOf(queryString);
		} catch (NullPointerException | IllegalArgumentException exception) {
			return NEW;
		}
	}
}
