/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Holds details for music items.  Requires Java 15+ for record support.
 *
 */
public record MusicItem(Long id, String title, 
		String artist, 
		LocalDate releaseDate, 
		BigDecimal price,
		MusicCategory musicCategory) {
	
	
	

	public Long id() {
		return id;
	}

	public String title() {
		return title;
	}

	public String artist() {
		return artist;
	}

	public LocalDate releaseDate() {
		return releaseDate;
	}

	public BigDecimal price() {
		return price;
	}

	public MusicCategory musicCategory() {
		return musicCategory;
	}
	
	
	
	

}