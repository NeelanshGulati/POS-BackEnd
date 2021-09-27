package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Orders;
import com.nagarro.repository.OrderRepository;

public class OrderService {
	OrderRepository orderRepository = new OrderRepository();

	public List<Orders> getAllOrders() {
		List<Orders> orderList = orderRepository.getOrders();

		if (orderList == null) {
			System.err.println("Empty List found!");
		}
		return orderList;
	}

	public int totalOrders() {
		return orderRepository.totalOrders();
	}

	public void addOrder(Orders order) {
		orderRepository.addOrder(order);
	}

}
