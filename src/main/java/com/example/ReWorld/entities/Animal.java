package com.example.ReWorld.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

@Table(name="animals")
@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String name;

	@OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
	private List<Pet> pets;

	@PreRemove
	private void preRemove() {
		pets.forEach(pet -> pet.setSpecies(null));
	}

	public Animal() {

	}

	public Animal(Integer id, String name, List<Pet> pets) {
		this.id = id;
		this.name = name;
		this.pets = pets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
