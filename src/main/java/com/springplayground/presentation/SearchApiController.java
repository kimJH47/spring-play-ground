package com.springplayground.presentation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springplayground.aop.annotation.Logging;
import com.springplayground.domain.Category;
import com.springplayground.domain.cache.CacheProduct;
import com.springplayground.dto.ProductDto;
import com.springplayground.service.LowestPriceService;
import com.springplayground.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchApiController {

	private final ProductService productService;

	private final LowestPriceService priceService;

	@Logging
	@GetMapping("/api/categories/{category}/detail")
	public ResponseEntity<String> findProductWithPagination(@PathVariable String category,
		@RequestParam Map<String, String> params) {
		return ResponseEntity.ok("");
	}

	@GetMapping("/api/categories/{category}")
	public ResponseEntity<List<ProductDto>> findByCategory(@PathVariable String category) {
		//http://localhost:8080/api/categories/TOP
		log.info("{}",category);
		return ResponseEntity.ok(productService.findByCategory(Category.valueOf(category)));
	}

	@GetMapping("/getZSETValue")
	public Set<?> get(String key) {
		Set<?> set = priceService.getZSETValue(key);
		return set;
	}

	@PutMapping("/product")
	public long save(@RequestBody CacheProduct cacheProduct) {
		return priceService.save(cacheProduct);
	}
}
