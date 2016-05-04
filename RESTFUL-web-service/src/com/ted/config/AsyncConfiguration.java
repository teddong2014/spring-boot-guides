package com.ted.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAsync
public class AsyncConfiguration {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
