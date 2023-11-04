package com.springplayground.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springplayground.domain.User;
import com.springplayground.dto.UserDto;
import com.springplayground.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<UserDto> find() {
		return userRepository.findAll().stream()
			.map(User::toDto)
			.collect(Collectors.toList());
	}
}
