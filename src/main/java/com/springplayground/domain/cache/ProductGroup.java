package com.springplayground.domain.cache;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductGroup {
	private String prodId;
	private List<CacheProduct> products;
}
