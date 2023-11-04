package com.springplayground.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springplayground.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
