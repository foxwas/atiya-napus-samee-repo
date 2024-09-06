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

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.domain.MusicItem;

public class CatalogTest {

	@Test
	public void testCatalogLookupPositive() {
		// DONE: Pass applicationContext.xml to the constructor
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull(ctx, "spring container should not be null");
		
		// DONE
		/*
		 * Look up the musicCatalog, 
		 * assert that it's not null
	     * and invoke its toString method.  
		 */	
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull(cat, "Catalog should not be null");
		System.out.println(cat.toString());		
		
		// Remember to close the Spring Context!
		ctx.close();
	}

	
	// DONE: DI Lab - annotate as test method
	@Test
	public void testCatalogPositive() {
		String keyword = "a";
		// DONE: Create the context, lookup the catalog.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// DONE: DI Lab - call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue(size>0, "Size should be greater than zero");
		System.out.println("Catalog size is " + cat.size());
		
		// DONE: DI Lab - call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertFalse(results.isEmpty(), "Should find at least one item in findByKeyword(a)");
		System.out.println("Number of items found: " + results.size());
		System.out.println(results);

		// DONE: Close the context.
		ctx.close();
	}

	/*
	 * DONE: Optional - You should have two different beans when you declare two and look up by name.
	 * NOTE: Not best practice to lookup by name. We'll see other techniques later.
	 * Commented out so it doesn't get in our way for non-optional parts.
	 */
	// @Test
	public void testCatalogLookpuByNamePostivie() {
		// Pass applicationContext.xml to the constructor
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Catalog cat1 = (Catalog)ctx.getBean("musicCatalog");
		Catalog cat2 = (Catalog)ctx.getBean("musicCatalog2");
		assertNotNull(cat1, "musicCatalog should not be null");
		assertNotNull(cat2, "musicCatalog2 should not be null");
		assertNotEquals(cat1, cat2, "The beans should not be equal");
		
		ctx.close();
	}	
	
}
