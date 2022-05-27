package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Album;
import com.example.demo.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repo;
	
	// get
	public List<Album> getAll(){
		return this.repo.findAll();
	}
	
	// get 1
	public Album retrieve(Long itemId) {
		return this.repo.findById(itemId).get();
	}
	
	// create
	public Album create(Album item) {
		return this.repo.save(item);
	}
	
	// update
	public Album update(Album itemId) {
		return this.repo.save(itemId);
	}
	
	// delete
	public void delete(Long itemId) {
		this.repo.deleteById(itemId);
	}
}
