package com.example.ReWorld.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String name;

	@Column(nullable = false)
	private Float weight;

	private LocalDate deathDate;

	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "species_id", referencedColumnName = "id", nullable = true)
	private Species species;

	@ManyToOne
	@JoinColumn(name = "animals_id", referencedColumnName = "id", nullable = true)
	private Animal animal;

	@OneToOne(mappedBy = "pet")
	private Order order;

	public Pet() {

	}

	public Pet(Integer id, String name, Float weight, LocalDate deathDate, LocalDate birthDate,
			Species species, Animal animal, Order order) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.deathDate = deathDate;
		this.birthDate = birthDate;
		this.species = species;
		this.animal = animal;
		this.order = order;
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

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
