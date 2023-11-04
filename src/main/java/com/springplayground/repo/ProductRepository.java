package com.springplayground.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springplayground.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
