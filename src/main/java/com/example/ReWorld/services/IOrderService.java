package com.example.ReWorld.services;

import java.util.List;

import com.example.ReWorld.entities.Order;
import com.example.ReWorld.models.OrderDTO;

public interface IOrderService {
	Order createOrder(OrderDTO orderDTO,Integer userID);
	List<Order> findAll();
	List<Order> historyOrder(Integer userId);
}
