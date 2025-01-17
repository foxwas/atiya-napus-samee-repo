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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Holds details for music items.  Requires Java 8+ for LocalDate support.
 *
 */
@Entity
@Table(name="Item")
// Create named query
@NamedQuery(name="MusicItem.findByArtist",
query="Select mi " +
      "FROM MusicItem mi " +
      " WHERE mi.artist = :artist")
public class MusicItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title, artist;
	private LocalDate releaseDate;
	@Column(name="cost")
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private MusicCategory musicCategory;
	
	// Declare a field to hold inventory items for the MusicItem-Inventory relationship
	// Declare setter and getter for this field   
	// Include annotations for the inventory relationship - set cascading.
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL)
	private Collection<Inventory> inventoryRecords = new ArrayList<Inventory>();
	public Collection<Inventory> getInventoryRecords() { 
		return inventoryRecords;
	}
	public void setInventoryRecords(Collection<Inventory> i) { inventoryRecords = i; }

	// Helper method to add inventory record - Done in first relationship lab
	public void addInventoryRecord(String location, int quantity) {
		// Done for you - Create a new Inventory object
		Inventory iv = new Inventory(location, quantity);

		// Add the new inventory record to the inventory records collection
		// Set the item property of the inventory instance to this item (this)
		getInventoryRecords().add(iv);	
		iv.setItem(this);
	}	
	
	// For internal use only.
	@Transient
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public MusicItem() {
	}

	/**
	 * Convenience constructor to initialize only the id
	 * @param id the id
	 */
	public MusicItem(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * Constructor not requiring an id - useful for creating new persistent entities
	 * @param title title of the item
	 * @param artist artist/band of the item
	 * @param releaseDate date it was released
	 * @param price price
	 * @param musicCategory The type of music
	 */
	public MusicItem(String title, String artist, String releaseDate,
			BigDecimal price, MusicCategory musicCategory) {
		this.setTitle(title);
		this.setArtist(artist);
		this.setReleaseDateAsString(releaseDate);
		this.setPrice(price);
		this.setMusicCategory(musicCategory);
	}
	
	/**
	 * Constructor requiring an id - useful to create instances for in-memory data stores
	 * @param id item's id
	 * @param title item's title
	 * @param artist artist/band of the item
	 * @param releaseDate date it was released
	 * @param price sell price
	 * @param musicCategory The type of music
	 */
	public MusicItem(Long id, String title, String artist, String releaseDate,
			BigDecimal price, MusicCategory musicCategory) {
		this.setId(id);
		this.setTitle(title);
		this.setArtist(artist);
		this.setReleaseDateAsString(releaseDate);
		this.setPrice(price);
		this.setMusicCategory(musicCategory);
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * For ease of setting a date via strings with a pattern like 2017-12-25 
	 * @param releaseDateString string with date pattern yyyy-MM-dd
	 */
	public void setReleaseDateAsString(String releaseDateString) {
		releaseDate = LocalDate.parse(releaseDateString, formatter); 
	}

	/**
	 * Value (business) equality.  Checks equality of the title, artist and releaseDate properties.
	 */
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o == this) {
			result = true;
		}
		else if (o instanceof MusicItem) {
			MusicItem other = (MusicItem) o;
			result = Objects.equals(this.getTitle(),       other.getTitle()) &&
					Objects.equals(this.getArtist(),      other.getArtist()) &&
					Objects.equals(this.getReleaseDate(), other.getReleaseDate());
		}
		return result; 
	}

	/**
	 * Hash code consistent with equals(). Uses the title, artist and releaseDate properties to compute hash.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.title, this.artist, this.releaseDate);
	} 
    
	public MusicCategory getMusicCategory() {
		return musicCategory;
	}

	public void setMusicCategory(MusicCategory musicCategory) {
		this.musicCategory = musicCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String category = musicCategory==null ? null : musicCategory.getDescription();
		return "MusicItem [id=" + id + ", title=" + title + ", artist="
				+ artist + ", releaseDate=" + releaseDate + ", price=" + price
				+ ", musicCategory=" + category + "]";
	}

}
