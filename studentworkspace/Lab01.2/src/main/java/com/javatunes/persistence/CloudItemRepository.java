package com.javatunes.persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

@Component
public class CloudItemRepository implements ItemRepository {

	@Override
	public MusicItem findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MusicItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MusicItem save(MusicItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(MusicItem item) {
		// TODO Auto-generated method stub

	}

}
