package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public Catalog catalog() {
		
		return new CatalogImpl();
	}
}
