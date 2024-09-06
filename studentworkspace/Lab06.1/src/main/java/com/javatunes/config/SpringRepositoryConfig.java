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
//Enable auto scanning for JPA Entities
@EntityScan(basePackages="com.javatunes")
public class SpringRepositoryConfig {
	
	@Bean
	public ItemRepository itemRepository() {
		return new JpaItemRepository();
	}


}