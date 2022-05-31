package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AlbumArtist;
import com.example.demo.repositories.AlbumArtistRepository;

@Service
public class AlbumArtistService {
	
	@Autowired
	private AlbumArtistRepository repo;
	
	// get
	public List<AlbumArtist> getAll(){
		return this.repo.findAll();
	}
	
	// get 1
	public AlbumArtist retrieve(Long itemId) {
		return this.repo.findById(itemId).get();
	}
	
	// create
	public AlbumArtist create(AlbumArtist item) {
		return this.repo.save(item);
	}
	
	// update
	public AlbumArtist update(AlbumArtist itemId) {
		return this.repo.save(itemId);
	}
	
	// delete
	public void delete(Long itemId) {
		this.repo.deleteById(itemId);
	}
}
