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
import org.springframework.context.annotation.Import;

import com.fox.config.AtiyaConfig;
import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

import gov.us.navy.NapusConfig;

// DONE: Declare as a Spring configuration class
// DONE: Add component scan for com.javatunes
@Configuration
@ComponentScan
@Import({NapusConfig.class, AtiyaConfig.class })
@ComponentScan(basePackages = "com.javatunes")
public class SpringConfig {

	// DONE: Declare the item repository bean
	@Bean
	ItemRepository itemRepository() {
		return new InMemoryItemRepository();
	}

	// DONE: Declare the catalog bean definition
	@Bean
	Catalog catalog() {
		CatalogImpl cat = new CatalogImpl();
		cat.setItemRepository(itemRepository());
		return cat;
	}
	
	@Bean
	public String getName() {
		return 
			"Atiya Napus Shamme";
	}

}