/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javatunes.config.SpringConfig;

// DONE: Run the tests with the special Spring extension
@ExtendWith(SpringExtension.class)
// DONE: Read SpringConfig.class to initialize the context and initialize Spring Boot
@SpringBootTest(classes={SpringConfig.class})
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CatalogTest {

    @Autowired
    Catalog cat;
    
	@Test
	public void test1_testCatalogFindByIdPositive() {
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(cat.findById(1L));  // I would have them add this line
		System.out.println("***\n");
	}

	@Test
	// DONE: 2nd part of lab - Fix the problem with this method.
	//@DirtiesContext
    public void test2_testDeletePositive() {
		System.out.println("\n*** Testing delete ***");
    		long oldSize = cat.size();
    		cat.remove(2L);
    		long newSize = cat.size();
    		System.out.println("***\n");
    		assertTrue (newSize == oldSize-1, "Delete should reduce size by one\n");
    }

    @Test
    public void test3_testSizePositive() {
		System.out.println("\n*** Testing size ***");
    		long expectedSize = 18L;
    		long currentSize = cat.size();
    		System.out.format("Current size is %s\n", currentSize);
    		System.out.println("***\n");
    		assertTrue(cat.size()==expectedSize, "Size should be 18");
    }
}
