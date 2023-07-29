package com.example.ReWorld.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "stories")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255)
	private String title;

	@Column(length = 10000)
	private String content;

	@Column(length = 255)
	private String description;

	private Integer liked;

	@Column(length = 25)
	private String scope;

	@Column(length = 255)
	private String image;

	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "animals_id", referencedColumnName = "id", nullable = true)
	private Animal animal;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	private User user;
	
	@Column(length = 255)
	private String species;

	public Story() {
	}

	public Story(Integer id, String title, String content, String scope) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.scope = scope;
	}

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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", content=" + content + ", description=" + description
				+ ", liked=" + liked + ", scope=" + scope + ", image=" + image + ", animal=" + animal + ", species="
				+ species + "]";
	}

}
