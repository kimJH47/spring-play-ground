package com.springplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {
	private long cartId;
	private long userId;
	private long productId;
	private int quantity;
	private long price;
}
