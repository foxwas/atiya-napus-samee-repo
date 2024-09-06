/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.Inventory;
import com.javatunes.domain.MusicItem;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={SpringConfig.class})
@Transactional
public class ItemRepositoryTest {

    // Inject a repository
	@Autowired
    ItemRepository repo;

	@Test
	public void testFindPositive() {
		Long id = 1L;

		System.out.println("\n*** Retrieving item from the database ***");

		// DONE: Get an item by id.
		MusicItem item = repo.getById(id);
		
		assertNotNull(item, "The MusicItem should not be null");
		System.out.println(item);
		System.out.println("***\n");
	}  

	@Test
	public void testInventoryAccessPositive() {
		System.out.println("\n*** Checking inventory ***");
		// Get item with id == 1
		MusicItem mi = repo.getById(Long.valueOf(1));

		// DONE: Get its inventory records
		Collection<Inventory> inventoryRecords = mi.getInventoryRecords();
		assertNotNull(inventoryRecords, "inventoryRecords should not be null");
		assertFalse(inventoryRecords.isEmpty(), "This item should have inventory records");
		
		// Print out all the records.
		System.out.println("\n***Inventory records for item with id == 1:***");
		for (Inventory cur: inventoryRecords) {
			System.out.println(cur);
		}
		System.out.println("***    ***\n");
		
	}

	
}
