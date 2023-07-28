package com.example.ReWorld.entities;

import java.sql.Date;

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
	private Date orderDate;

	@Column(length = 255)
	private String message;

	@Column(length = 255)
	private String happening;

	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private OrderStatus orderStatus;
	
	@OneToOne(mappedBy = "order")
	private Payment payment;
	
	@OneToOne
	@JoinColumn(name = "customers_id", referencedColumnName = "id", nullable = false)
	private Customer customer;

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

	public Order(Integer id, Integer total, Date orderDate, String message, String happening, OrderStatus orderStatus,
			Payment payment, Customer customer, Pet pet, ServicePackage service) {
		this.id = id;
		this.total = total;
		this.orderDate = orderDate;
		this.message = message;
		this.happening = happening;
		this.orderStatus = orderStatus;
		this.payment = payment;
		this.customer = customer;
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

	public String getHappening() {
		return happening;
	}

	public void setHappening(String happening) {
		this.happening = happening;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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



}
