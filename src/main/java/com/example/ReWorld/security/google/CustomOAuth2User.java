package com.example.ReWorld.security.google;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.ReWorld.entities.User;
import com.example.ReWorld.security.config.UserPrinciple;

public class CustomOAuth2User extends UserPrinciple implements OAuth2User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OAuth2User oauth2User;

	public CustomOAuth2User(User user, OAuth2User oauth2User) {

		super(user.getId(), user.getName(), user.getPassword(), user.getUsername(), user.getLocked(), user.getEnabled(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
						.collect(Collectors.toList()));

		this.oauth2User = oauth2User;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return oauth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return oauth2User.getAuthorities();
	}

}