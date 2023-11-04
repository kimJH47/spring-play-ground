package com.springplayground.domain.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CacheProduct {
	private String productGroupId;
	private String productId;
	private Long price;
}
