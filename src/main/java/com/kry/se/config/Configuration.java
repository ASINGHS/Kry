package com.kry.se.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
	public class Configuration {
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
