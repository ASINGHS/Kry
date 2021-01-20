package com.kry.se.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
//public class Configuration extends RestTemplate{
	public class Configuration {
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
