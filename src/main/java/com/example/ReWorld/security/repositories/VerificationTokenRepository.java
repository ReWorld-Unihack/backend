package com.example.ReWorld.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.User;
import com.example.ReWorld.entities.VerificationToken;


public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);

	VerificationToken findByUser(User user);
}
