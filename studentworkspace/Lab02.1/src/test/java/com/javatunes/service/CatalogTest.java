/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

public class CatalogTest {

	@Test	// Annotate as test method
	public void testCatalogLookupPositive() {
	
		// TODO: Create context, pass SpringConfig.class to the constructor
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		assertNotNull(ctx, "spring container should not be null");
		
		 // Look up the musicCatalog, assert that it's not null, and invoke its toString method.  
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull(cat, "Catalog should not be null");
		System.out.println(cat.toString());		
		
		// Remember to close the Spring Context!
		ctx.close();
	}

	
	@Test	// Annotate as test method
	public void testCatalogPositive() {
		String keyword = "a";
		
		// TODO: Create context, pass SpringConfig.class to the constructor
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// DONE: DI Lab - call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue(size>0, "Size should be greater than zero");
		System.out.println("Catalog size is " + cat.size());
		
		// Call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertFalse(results.isEmpty(), "Should find at least one item in findByKeyword(a)");
		System.out.println("Number of items found: " + results.size());
		System.out.println(results);

		// Close the context.
		ctx.close();
	}
}
