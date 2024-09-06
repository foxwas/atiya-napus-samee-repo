/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

@RepositoryTX
public class JpaItemRepository implements ItemRepository {

	@PersistenceContext
	private EntityManager em;

	public MusicItem findById(Long id) {
		MusicItem item = em.find(MusicItem.class, id);
		return item;
	}

	@Override
	public Collection<MusicItem> findAll() {
		// Implemented with dynamic query.
	    TypedQuery<MusicItem> q = em.createQuery("SELECT m FROM MusicItem m", MusicItem.class);
	    return q.getResultList();
	}
	
	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		// Not implemented
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.NEVER)
	public long count() {
		// Not implemented
		return 0;
	}
	
	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
		// Not implmented
		return null;
	}
	
	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// Not implemented
		return null;
	}
	
	@Override
	public MusicItem save(MusicItem item) {
		em.persist(item);
		return item;
	}

	@Override
	public void delete(MusicItem item) {
		em.remove(item);
		
	}
}
