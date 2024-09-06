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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={SpringConfig.class})
@Transactional
public class ItemRepositoryTest {

    // TODO: Inject a repository
	@Autowired
    ItemRepository repo;

	@Test
	public void testFindPositive() {
		Long id = 1L;

		System.out.println("\n*** Retrieving item from the database ***");

		// TODO: Get an item by id.
		Optional<MusicItem> item = repo.findById(id);
		
		
		assertNotNull(item, "The MusicItem should not be null");
		System.out.println(item);
		System.out.println("***\n");
		System.out.println(repo.count());
		
		//System.out.println(repo.findByArtist("Madonna"));
	}  

	// TODO: Finish this method to search by artist, and check that it works by searching on Madonna.
	// TODO: Uncomment the @Test
	@Test
	public void testFindByArtistPositive() {
		String artist = "Madonna";

		// TODO: Call the method to search by artist based on the artist variable defined above.
		Collection<MusicItem> results =repo.findByArtist(artist);
		
		// We should find at least one item for this artist.
		assertTrue(results.size()>0, "Should find at least one item in findByKeyword(a)");
		System.out.println("Number of items found: " + results.size());
		System.out.println(results);
	}
	
}
