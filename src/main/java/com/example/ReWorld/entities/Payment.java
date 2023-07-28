package com.example.ReWorld.entities;

import java.sql.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Date paymentDate;

	@Column(nullable = false)
	private Integer money;

	@Column(length = 255)
	private String message;

	@Column(length = 50)
	private String account;

	@OneToOne
	@JoinColumn(name = "orders_id", referencedColumnName = "id", nullable = true)
	private Order order;

	public Payment() {

	}

	public Payment(Integer id, Date paymentDate, Integer money, String message, String account, Order order) {
		this.id = id;
		this.paymentDate = paymentDate;
		this.money = money;
		this.message = message;
		this.account = account;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
