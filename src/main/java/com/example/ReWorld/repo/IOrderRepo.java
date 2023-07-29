package com.example.ReWorld.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.Order;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(Integer userId);
}
