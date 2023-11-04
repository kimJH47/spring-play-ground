package com.springplayground.webclient.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.event.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springplayground.common.GlobalLogger;
import com.springplayground.webclient.ClientService;
import com.springplayground.webclient.dto.KakaoApiResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ApiController {
	private static final String ERROR_FORMAT = "[ERROR] {} {} -> {}";


	private final ApiService apiService;
	private final ClientService clientService;

	private final GlobalLogger globalLogger;

	@GetMapping("/test/kakao/{query}")
	public Mono<ResponseEntity<KakaoApiResponseDto>> test(@PathVariable String query) {
		Mono<KakaoApiResponseDto> kakakoMono = clientService.callKakaoAddress(query);
		return kakakoMono.map(dto -> ResponseEntity.ok().body(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTest1(@PathVariable Long id) {
		log.debug("param = {}", id);
		return ResponseEntity.ok().body("성공");
	}

	@GetMapping("/{id}/{email}")
	public ResponseEntity<?> getTest2(@PathVariable Long id, @PathVariable("email") String email) {
		log.debug("param = {}", id);
		log.debug("param = {}", email);
		return ResponseEntity.ok().body("성공");
	}

	@GetMapping("/get")
	public ResponseEntity<?> getTest3(@RequestParam("id") Long id, @RequestParam("email") String email) {
		log.debug("param = {}", id);
		log.debug("param = {}", email);
		return ResponseEntity.ok().body("성공");
	}

	@PostMapping
	public ResponseEntity<?> postTest1(@RequestBody TestRequest testRequest) {
		log.debug("param = {}", testRequest.getEmail());
		log.debug("param = {}", testRequest.getId());

		return ResponseEntity.ok().body("성공");
	}

	@PostMapping("/log-test")
	public void logTest(HttpServletRequest request) {
		globalLogger.log(Level.INFO, ERROR_FORMAT, request.getRequestURI(), request.getMethod(),"test msg");
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
}
