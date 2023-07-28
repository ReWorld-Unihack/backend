package com.example.ReWorld.security.services;

import java.util.Optional;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.User;
import com.example.ReWorld.entities.VerificationToken;
import com.example.ReWorld.security.repositories.IUserRepository;
import com.example.ReWorld.security.repositories.VerificationTokenRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {
		return tokenRepository.findByToken(VerificationToken);
	}

	@Override
	public void saveRegisteredUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void createVerificationToken(User user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User register(User user) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}
}
