package com.example.ReWorld.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	private String status;

	@Column(length = 255)
	private String message;
	
	@OneToOne
	@JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = false)
	private Order order;


	public OrderStatus(Integer id, String status, String message, Order order) {
		this.id = id;
		this.status = status;
		this.message = message;
		this.order = order;
	}

	public OrderStatus() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
