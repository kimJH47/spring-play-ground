package com.springplayground.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springplayground.domain.Category;
import com.springplayground.dto.ProductDto;
import com.springplayground.repo.ProductQuryDslRepository;
import com.springplayground.repo.ProductSearchCondition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	private final ProductQuryDslRepository productQuryDslRepository;

	@Transactional(readOnly = true)
	public List<ProductDto> findWithSearchCondition(Category category, Map<String, String> param) {
		ProductSearchCondition condition = ProductSearchCondition.createWithCategoryAndAttributes(
			category, param);
		log.info("condition = {}", condition);
		return productQuryDslRepository.findBySearchCondition(condition);
	}

	@Transactional(readOnly = true)
	public List<ProductDto> test(Category category, Map<String, String> param) {
		ProductSearchCondition condition = ProductSearchCondition.createWithCategoryAndAttributes(
			category, param);
		log.info("condition = {}", condition);
		return productQuryDslRepository.test(condition);
	}

	public List<ProductDto> findByCategory(Category category) {
		return productQuryDslRepository.findByCategoryWithPaginationOrderByBrandNew(category, PageRequest.of(1, 20));
	}
}
