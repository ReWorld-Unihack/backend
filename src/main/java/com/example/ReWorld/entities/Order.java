package com.example.ReWorld.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer total;

	@Column(nullable = false)
	private LocalDateTime orderDate;

	@Column(length = 255)
	private String message;
	
	@Column(length = 15)
	private String phone;
	
	@Column(length = 255)
	private String address;
	
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private OrderStatus orderStatus;
	
	@OneToOne(mappedBy = "order")
	private Payment payment;
	

	@ManyToOne
	@JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "pets_id", referencedColumnName = "id", nullable = false)
	private Pet pet;

	@OneToOne
	@JoinColumn(name = "services_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServicePackage service;

	public Order() {
	}

	public Order(Integer id, Integer total, LocalDateTime orderDate, String message, OrderStatus orderStatus,
			Payment payment, Pet pet, ServicePackage service) {
		this.id = id;
		this.total = total;
		this.orderDate = orderDate;
		this.message = message;
		this.orderStatus = orderStatus;
		this.payment = payment;
		this.pet = pet;
		this.service = service;
	}

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



	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public ServicePackage getService() {
		return service;
	}

	public void setService(ServicePackage service) {
		this.service = service;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
