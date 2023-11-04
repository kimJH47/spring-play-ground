package com.springplayground.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springplayground.domain.Cart;
import com.springplayground.dto.CartDto;
import com.springplayground.repo.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	private final CartRepository cartRepository;

	@Transactional(readOnly = true)
	public List<CartDto> findByUserId(Long userId) {
		return cartRepository.findByUserId(userId)
			.stream()
			.map(Cart::toDto)
			.collect(Collectors.toList());
	}
}
