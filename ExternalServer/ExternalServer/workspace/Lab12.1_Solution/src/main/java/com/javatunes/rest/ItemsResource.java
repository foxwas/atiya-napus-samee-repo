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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	Catalog cat;

	// Handler method to forward to the search form
 	@RequestMapping
	public Collection<MusicItem> getAllItems() {
		Collection<MusicItem> results = (Collection<MusicItem>)cat.findAll();
		return results;
	}
	
    @RequestMapping("/{id}") 	
	public MusicItem findItem(@PathVariable("id") Long id) {
	   return cat.findById(id);
	}

}