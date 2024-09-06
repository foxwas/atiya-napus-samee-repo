/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

@ServiceTX
public class CatalogImpl implements Catalog{

	@Autowired
	private ItemRepository itemRepository;

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public MusicItem findById(Long id) {
		return itemRepository.findById(id);
	}

	@Override
	public Collection<MusicItem> findAll() {
		return itemRepository.findAll();
	}
	
	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.findByKeyword(keyword);
	}

	@Override
	public long size() {
		return itemRepository.count();
	}

	@Override
	public void save(MusicItem item) {
		itemRepository.save(item);
	}
	
	@Override
	public void saveBatch(Collection<MusicItem> items) {
		RuntimeException thrown = null;
		for (MusicItem musicItem : items) {
			System.out.println("Attempting to save " + musicItem);
			try {
			itemRepository.save(musicItem);
			} 
			catch (RuntimeException e) { thrown = e; }
		}
		if (thrown != null) {
			throw thrown;
		}
	}
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}

}
