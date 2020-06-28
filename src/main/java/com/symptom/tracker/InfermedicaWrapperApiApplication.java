package com.symptom.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class InfermedicaWrapperApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfermedicaWrapperApiApplication.class, args);
	}

	@Bean
	RestTemplate infermedicaRestTemplate(RestTemplateBuilder restTemplateBuilder,
										 @Value("${infermedica.base-url}") String baseUrl,
										 @Value("${infermedica.read-timeout}") Duration readTimeout,
										 @Value("${infermedica.connect-timeout}") Duration connectTimeout) {
		return restTemplateBuilder
				.rootUri(baseUrl)
				.setReadTimeout(readTimeout)
				.setConnectTimeout(connectTimeout)
				.build();

	}
}
