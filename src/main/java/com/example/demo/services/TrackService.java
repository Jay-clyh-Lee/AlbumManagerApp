package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Album;
import com.example.demo.models.Track;
import com.example.demo.repositories.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	private TrackRepository repo;
	
	@Autowired
	private AlbumService service;
	
	// get
	public List<Track> getAll(){
		return this.repo.findAll();
	}
	
	// get 1
	public Track retrieve(Long itemId) {
		return this.repo.findById(itemId).get();
	}
	
	// create
	public Track create(Track item, Long album_id) {
		
		Album album = this.service.retrieve(album_id);
		
		if ( album == null ) return null;
		
		item.setAlbum(album);
		
		return this.repo.save(item);
	}
	
	// update
	public Track update(Track itemId) {
		return this.repo.save(itemId);
	}
	
	// delete
	public void delete(Long itemId) {
		this.repo.deleteById(itemId);
	}
}
