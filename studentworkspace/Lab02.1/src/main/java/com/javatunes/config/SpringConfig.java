/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// TODO: Declare as a Spring configuration class
@Configuration
// TODO: Add component scan for com.javatunes
@ComponentScan("com.javatunes")
public class SpringConfig {

	// TODO: Declare the item repository bean
	@Bean
	public ItemRepository itemRepo() {
		return new InMemoryItemRepository();
	}

	// TODO: Declare the catalog bean definition
	@Bean
	public Catalog catlog() {
		CatalogImpl catalog = new CatalogImpl();
		catalog.setItemRepository(itemRepo());
		return catalog;
	}
}