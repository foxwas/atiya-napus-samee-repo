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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// TODO: Annotate as REST controller
// TODO: Annotate to map this controller to /items
@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	Catalog cat;

	// TODO: annotate as a handler method
	@RequestMapping
	public Collection<MusicItem> getAllItems() {
		Collection<MusicItem> results = cat.findAll();
		return results;
	}

	// TODO: Annotate as a handler method that matches URI of form /items/5
	// TODO: Annotate to bind the URI template variable to the id parameter	
	@RequestMapping("/{id}")
 	public MusicItem findItem(@PathVariable("id") Long id) {
	   return cat.findById(id);
	}

}