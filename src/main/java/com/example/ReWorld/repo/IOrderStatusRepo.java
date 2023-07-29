package com.example.ReWorld.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReWorld.entities.OrderStatus;

public interface IOrderStatusRepo extends JpaRepository<OrderStatus, Integer> {
	List<OrderStatus> findByOrderUserId(Integer userId);
}
