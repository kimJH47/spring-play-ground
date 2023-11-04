package com.springplayground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springplayground.common.GlobalLogger;

@Configuration
public class LoggerConfig {

	@Bean
	public GlobalLogger globalLogger() {
		return new GlobalLogger();
	}
}
