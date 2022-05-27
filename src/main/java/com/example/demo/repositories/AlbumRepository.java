package com.example.demo.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	
	List<Album> findAll();
}
