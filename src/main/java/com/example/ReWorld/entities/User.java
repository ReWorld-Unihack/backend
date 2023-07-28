package com.example.ReWorld.entities;

import java.util.List;
import java.util.Set;

import com.example.ReWorld.constants.AuthenticationProvider;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false, length = 100)
	private String username;

	private String password;

	@Column(length = 100)
	private String name;
	
	private Boolean locked = false;
	
	@Column(length = 255)
	private String avatar;
	
	@Column(name = "enabled")
	private Boolean enabled = false;

	@Enumerated(EnumType.STRING)
	private AuthenticationProvider authProvider;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Role> roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public AuthenticationProvider getAuthProvider() {
		return authProvider;
	}
	public void setAuthProvider(AuthenticationProvider authProvider) {
		this.authProvider = authProvider;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


}