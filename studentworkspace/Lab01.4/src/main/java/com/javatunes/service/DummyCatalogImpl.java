package com.javatunes.service;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.javatunes.domain.MusicItem;

// Commented out so it doesn't get in our way for non-optional parts.
// @Component ("musicCatalog2") 
public class DummyCatalogImpl implements Catalog {

	@Override
	public MusicItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
