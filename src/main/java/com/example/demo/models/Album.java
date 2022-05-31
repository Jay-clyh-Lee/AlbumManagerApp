package com.example.demo.models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=25)
	private String title;
	
	@Size(min=1, max=25)
	private String artist;
	
	@NotEmpty
	private int year;
	
	@OneToMany(mappedBy="album", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Track> track;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id") //{entity}_{attribute}
	private User user;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
        
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	// getter setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}	
	public List<Track> getTrack() {
		return track;
	}
	public void setTrack(List<Track> track) {
		this.track = track;
	}
	
	// constructor
	public Album () {}
}