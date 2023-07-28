package com.example.ReWorld.entities;

import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 50)
    private String name;
    
    @OneToMany(mappedBy = "species", fetch = FetchType.LAZY)
    private List<Pet> pets;
    
	@PreRemove
	private void preRemove() {
	  pets.forEach( pet -> pet.setSpecies(null));
	}
	
	public Species() {

	}

	public Species(Integer id, String name, List<Pet> pets) {
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
