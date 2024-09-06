/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.javatunes.domain.DomainSettings;
import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;

// TODO: Declare as a configuration class
@Configuration
@Import(SpringDomainConfig.class)
public class SpringRepositoryConfig {
	
	@Autowired
	private DomainSettings settings;
	
	// TODO: Declare as a bean
	@Bean
	ItemRepository itemRepository() {
		InMemoryItemRepository repository = new InMemoryItemRepository();
		repository.setMaxSearchResults(settings.maxSearchResults());
		return repository;
	}

}