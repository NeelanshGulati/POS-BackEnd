package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.nagarro.model.Orders;
import com.nagarro.service.OrderService;

@CrossOrigin("*")
@Path("/")
@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {
	OrderService orderService = new OrderService();

	@GET
	@Path("/orders")
	public List<Orders> getOrders() {
		List<Orders> orders = orderService.getAllOrders();
		return orders;
	}

	@GET
	@Path("/orders/count")
	public int countOrders() {
		return orderService.totalOrders();
	}

	@POST
	@Path("/orders")
	public Orders addOrders(Orders order) {
		orderService.addOrder(order);
		return order;
	}
}
