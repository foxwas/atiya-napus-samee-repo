/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// TODO: Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
	// TODO: Inject the repository
	@Autowired
	ItemRepository repository;

	// TODO: Configure the catalog bean
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	Catalog catalog() {
		CatalogImpl cat = new CatalogImpl();
		// TODO: Set the repository before returning it
		cat.setItemRepository(repository);
		return cat;
	}

}