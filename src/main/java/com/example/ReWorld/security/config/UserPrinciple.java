package com.example.ReWorld.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ReWorld.entities.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String userName;

	private String password;

	private String name;

	private Boolean locked = false;

	private Boolean enable;

	private Collection<? extends GrantedAuthority> roles;

	public UserPrinciple(Integer id, String name, String password, String userName, Boolean locked, Boolean enable,
			Collection<? extends GrantedAuthority> roles) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.locked = locked;
		this.roles = roles;
		this.enable = enable;
		this.name = name;
	}

	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

		return new UserPrinciple(user.getId(), user.getName(), user.getPassword(), user.getUsername(), user.getLocked(),
				user.getEnabled(), authorities);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserPrinciple user = (UserPrinciple) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
