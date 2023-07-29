package com.example.ReWorld.services;

import java.util.List;

import com.example.ReWorld.entities.OrderStatus;

public interface IOrderStatusService {
	List<OrderStatus> history(Integer userId);
}
