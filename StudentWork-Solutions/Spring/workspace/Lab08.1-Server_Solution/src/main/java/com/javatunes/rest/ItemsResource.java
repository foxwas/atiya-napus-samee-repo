/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.rest;

import java.util.Collection;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItemCollectionWrapper;
import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	Catalog cat;

	    // GET all items - Return wrapped collection
		@GetMapping
		public MusicItemCollectionWrapper getAllItems() {
			Collection<MusicItem> results = cat.findAll();
			return new MusicItemCollectionWrapper(results);
		}


		// GET one item by id
		@GetMapping("/{id}")
		public MusicItem findItem(@PathVariable("id") Long id) {
		   return cat.findById(id);
		}
		
	 	// Create an item for POST request and URL like /items
	   	// DONE: Add @PostMapping
 		// DONE: Add @ResponseStatus to specify CREATED status
	 	@PostMapping
	 	@ResponseStatus(HttpStatus.CREATED)
	 	public MusicItem createItem (@RequestBody MusicItem item, HttpServletResponse response) {
	 		System.out.println("ItemController: createItem called with: " + item);
	 		MusicItem newItem = cat.add(item);
	 		
	 		// DONE: Set the location header using the response object
	 		response.setHeader("Location", "/items/" + newItem.id());
	 		
	 		return newItem;
	 	} 	
	 	
	 	// Delete an item for DELETE request and URL like /items/2
	 	// DONE: Add @DeleteMapping specifying the correct URL and HTTP method
 		// DONE: Add @ResponseStatus to specify NO_CONTENT status
 		// DONE: Add @PathVariable to method signature to correctly bind the id parameter
	 	@DeleteMapping("/{id}")
	 	@ResponseStatus(HttpStatus.NO_CONTENT)
	 	public void deleteItem (@PathVariable("id") Long id) {
	 		System.out.println("ItemController: deleteItem called with: " + id);
	 		cat.remove(id);
	 	} 	
		

	 	// Update an item for PUT request and URL like /items/2 - for this method we've decided that only the
	 	// title, artist, and price can be updated.
	 	// DONE: Add @PutMapping specifying the correct URL and HTTP method
 		// DONE: Add @PathVariable to method signature to correctly bind the id parameter
 		// DONE: Add @RequestBody to method signature to correctly bind the item parameter
	 	@PutMapping("/{id}")
	 	public MusicItem updateItem (@PathVariable("id") Long id, @RequestBody MusicItem item) {
	 		System.out.println("ItemController: updateItem called with: " + item);
	 		MusicItem found = cat.findById(id);
	 		System.out.println("updateItem itemIn = " + item);
	 		System.out.println("updateItem item to update = " + found);
	 		if (found != null) { 
	 			// Since we're using immutable Java records now, we need to delete the old item from the catalog
	 			// We then create a new one using and add in the new one.
	 			cat.updateItem(new MusicItem(id, item.title(), item.artist(), item.releaseDate(), item.price(), item.musicCategory()));
	 		}
	 		return item;
	 	} 	  	
}