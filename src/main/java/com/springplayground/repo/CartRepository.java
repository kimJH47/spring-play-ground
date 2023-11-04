package com.springplayground.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springplayground.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserId(Long userId);

	@Query("select c from Cart c where c.user.id = :userId")
	List<Cart> findByUserIdNotUserJoin(@Param("userId") final Long userId);

}
