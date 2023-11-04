package com.springplayground.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
			.group("v1")
			.pathsToMatch("/api/**")
			.build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.info(new Info().title("spring play ground api docs")
				.description("api document for spring play ground")
				.version("1.0.0"));
	}
}
