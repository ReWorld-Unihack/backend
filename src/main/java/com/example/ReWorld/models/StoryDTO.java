package com.example.ReWorld.models;

import java.time.LocalDate;

public class StoryDTO {
	private Integer id;

	private String title;

	private String content;
	
	private String description;
	
	private Boolean liked;
	
	private String scope;
	
	private String image;

	private Integer animalId;
	
	private LocalDate date;
	
	private String species;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
