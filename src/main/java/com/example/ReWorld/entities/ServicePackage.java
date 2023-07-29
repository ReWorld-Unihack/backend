package com.example.ReWorld.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "service_packages")
public class ServicePackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 10000)
	private String description;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(length = 255)
	private String image;
	
	public ServicePackage() {
	}
	
	public ServicePackage(Integer id, String name, String description, Integer price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
