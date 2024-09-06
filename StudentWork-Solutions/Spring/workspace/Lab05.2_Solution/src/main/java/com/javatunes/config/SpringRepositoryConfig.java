/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.JpaItemRepository;

@Configuration
// DONE: Enable finding of Entity Classes in com.javatunes and sub-packages
@EntityScan(basePackages="com.javatunes")
public class SpringRepositoryConfig {

	// Configure an JPA item repository bean
	@Bean
	public ItemRepository itemRepository() {
		return new JpaItemRepository();
	}
	

}