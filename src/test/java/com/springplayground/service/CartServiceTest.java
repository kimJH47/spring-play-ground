package com.springplayground.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.springplayground.domain.Cart;
import com.springplayground.domain.Product;
import com.springplayground.domain.User;
import com.springplayground.repo.CartRepository;
import com.springplayground.repo.ProductRepository;
import com.springplayground.repo.UserRepository;

@SpringBootTest
@Transactional
class CartServiceTest {

	@Autowired
	CartService cartService;

	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;


	@BeforeEach
	void setUp() {
		User user = userRepository.findById(1L)
			.orElseThrow();
		Product product = productRepository.findById(1L)
			.orElseThrow();
		Cart cart = Cart.create(user, product, 10);
		cartRepository.save(cart);
		entityManager.flush();
		entityManager.clear();

	}

	@Test
	@DisplayName("")
	void find() throws Exception {
		//given
		List<Cart> carts = cartRepository.findByUserId(1L);
		Cart cart = carts.get(0);

		System.out.println(cart);
		System.out.println("================");

		System.out.println(cart.getUser());
		System.out.println(cart.getProduct());

		//when
		//then

	}
}