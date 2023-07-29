package com.example.ReWorld.models;

import java.sql.Date;
import java.time.LocalDate;

public class OrderDTO {
	private Integer id;

	private Integer total;

	private Date orderDate;

	private String message;
	
	private String phone;
	
	private String address;
	
	private Float weight;

	private LocalDate deathDate;

	private LocalDate birthDate;
	
	private String species;
	
	private String name;
	
	private Integer serviceId;
	
	private Integer animalId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
}
