package com.springplayground.domain.cache;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Keyword {
	private String keyword;
	private List<ProductGroup> productGroups;
}
