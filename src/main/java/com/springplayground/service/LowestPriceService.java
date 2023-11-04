package com.springplayground.service;

import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springplayground.domain.cache.CacheProduct;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LowestPriceService {

	private final RedisTemplate<String, Object> redisTemplate;

	public Set<?> getZSETValue(String key) {
		return redisTemplate.opsForZSet().rangeWithScores(key, 0, 9);
	}

	public long save(CacheProduct cacheProduct) {
		redisTemplate.opsForZSet()
			.add(cacheProduct.getProductGroupId(), cacheProduct.getProductId(), cacheProduct.getPrice());
		Long rank = redisTemplate.opsForZSet().rank(cacheProduct.getProductGroupId(), cacheProduct.getProductId());
		return rank != null ? rank : -1;
	}
}
