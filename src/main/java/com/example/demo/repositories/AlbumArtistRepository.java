package com.example.demo.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AlbumArtist;

@Repository
public interface AlbumArtistRepository extends CrudRepository<AlbumArtist, Long> {
	
	List<AlbumArtist> findAll();
}
