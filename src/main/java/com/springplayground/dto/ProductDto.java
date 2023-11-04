package com.springplayground.dto;

import com.springplayground.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ProductDto {
	private Long id;
	private String name;
	private String brandName;
	private Long price;
	private Category category;
}
