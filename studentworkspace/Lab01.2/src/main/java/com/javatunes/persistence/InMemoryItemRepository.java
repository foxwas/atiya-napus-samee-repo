/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

@Component
public class InMemoryItemRepository implements ItemRepository {

	// For internal use only.
	private  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<MusicItem> catalogData =  new ArrayList<>(Arrays.asList(
			new MusicItem(1L, "Diva", "Annie Lennox", LocalDate.parse("1992-01-04", formatter), new BigDecimal("13.99"), MusicCategory.POP),
			new MusicItem(2L,"Dream of the Blue Turtles", "Sting", LocalDate.parse("1985-02-05", formatter), new BigDecimal("14.99"), MusicCategory.POP),
			new MusicItem(3L,"Trouble is...", "Kenny Wayne Shepherd Band", LocalDate.parse("1997-08-08", formatter), new BigDecimal("14.99"), MusicCategory.BLUES),
			new MusicItem(4L,"Lie to Me", "Jonny Lang", LocalDate.parse("1997-08-26", formatter), new BigDecimal("17.97"), MusicCategory.BLUES),
			new MusicItem(5L,"Little Earthquakes", "Tori Amos", LocalDate.parse("1992-01-18", formatter), new BigDecimal("14.99"), MusicCategory.ALTERNATIVE),
			new MusicItem(6L,"Seal", "Seal", LocalDate.parse("1991-08-18", formatter), new BigDecimal("17.97"), MusicCategory.POP),
			new MusicItem(7L,"Ian Moore", "Ian Moore", LocalDate.parse("1993-12-05", formatter), new BigDecimal("9.97"), MusicCategory.CLASSICAL),
			new MusicItem(8L,"So Much for the Afterglow", "Everclear", LocalDate.parse("1997-01-19", formatter), new BigDecimal("13.99"), MusicCategory.ROCK),
			new MusicItem(9L,"Surfacing", "Sarah McLachlan", LocalDate.parse("1997-12-04", formatter), new BigDecimal("17.97"), MusicCategory.ALTERNATIVE),
			new MusicItem(10L,"Hysteria", "Def Leppard", LocalDate.parse("1987-06-20", formatter), new BigDecimal("17.97"), MusicCategory.ROCK),
			new MusicItem(11L,"A Life of Saturdays", "Dexter Freebish", LocalDate.parse("2000-12-06", formatter), new BigDecimal("16.97"), MusicCategory.RAP),
			new MusicItem(12L,"Human Clay", "Creed", LocalDate.parse("1999-10-21", formatter), new BigDecimal("18.97"), MusicCategory.ROCK),
			new MusicItem(13L,"My, I'm Large", "Bobs", LocalDate.parse("1987-02-20", formatter), new BigDecimal("11.97"), MusicCategory.COUNTRY),
			new MusicItem(14L,"So", "Peter Gabriel", LocalDate.parse("1986-10-03", formatter), new BigDecimal("17.97"), MusicCategory.POP),
			new MusicItem(15L,"Big Ones", "Aerosmith", LocalDate.parse("1994-05-08", formatter), new BigDecimal("18.97"),MusicCategory.ROCK),
			new MusicItem(16L,"90125", "Yes", LocalDate.parse("1983-10-16", formatter), new BigDecimal("11.97"),MusicCategory.ROCK),
			new MusicItem(17L,"1984", "Van Halen", LocalDate.parse("1984-08-19", formatter), new BigDecimal("11.97"), MusicCategory.ROCK),
			new MusicItem(18L,"Escape", "Journey", LocalDate.parse("1981-02-25", formatter), new BigDecimal("11.97"), MusicCategory.CLASSIC_ROCK)		));

	private Integer maxSearchResults = 30;

	// Accessors
	public Integer getMaxSearchResults() {
		return maxSearchResults;
	}
	public void setMaxSearchResults(Integer maxSearchResults) {
		this.maxSearchResults = maxSearchResults;
	}

	@Override
	public MusicItem findOne(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.  
	    Optional<MusicItem> itemOptional = catalogData.stream()
	            .filter(item -> item.id().equals(id))
	            .findAny();		
	    return itemOptional.orElse(null);  // Returns item if found, else returns null
	}
		
	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {

		String artistLow = artist.toLowerCase();
		String titleLow = title.toLowerCase();

		// Uses Java 8 Streams, and filters with a lambda that matches on title or artist
		// Uses a "finisher" to limit the side of the list.  This can be done more efficiently by limiting while you're creating the list
		// We do it this way for (relative) simplicity.  See https://stackoverflow.com/questions/33853611/limit-groupby-in-java-8 for guide to a more efficient solution
	    return catalogData.stream()
	            .filter(item -> item.title().toLowerCase().contains(titleLow) ||
	                            item.artist().toLowerCase().contains(artistLow))
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));		
	}
	
	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// Uses Java 8 Streams, and filters with a lambda that matches on musicCategory
		// Uses a "finisher" to limit the side of the list, same as findByArtistContainingOrTitleContainingAllIgnoreCase
	    return catalogData.stream()
	            .filter(item->item.musicCategory() == category)
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));	            
	}

	public Collection<MusicItem> findAll() {
		return Collections.unmodifiableCollection(catalogData);
	}

	@Override
	public long count() {
		return catalogData.size();
	}

	@Override
	public MusicItem save(MusicItem item) {
		// Not implemented
		return null;
	}

	@Override
	public void delete(MusicItem item) {
		// Not implemented
	}

}
