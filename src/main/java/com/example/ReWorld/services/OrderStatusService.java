package com.example.ReWorld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.OrderStatus;
import com.example.ReWorld.repo.IOrderStatusRepo;

@Service
public class OrderStatusService implements IOrderStatusService{

	@Autowired
	private IOrderStatusRepo orderStatusRepo;
	
	@Override
	public List<OrderStatus> history(Integer userId) {
		return orderStatusRepo.findByOrderUserId(userId);
	}

}
