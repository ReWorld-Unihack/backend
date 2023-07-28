package com.example.ReWorld.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ReWorld.entities.User;
import com.example.ReWorld.entities.VerificationToken;

import java.util.Optional;

import javax.security.auth.login.AccountException;

public interface IUserService extends UserDetailsService {
	Optional<User> findByUsername(String username);

	void createVerificationToken(User user, String token);

	VerificationToken getVerificationToken(String VerificationToken);

	User register(User user) throws AccountException;

	void saveRegisteredUser(User user);
}
