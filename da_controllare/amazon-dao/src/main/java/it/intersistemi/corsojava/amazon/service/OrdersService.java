package it.intersistemi.corsojava.amazon.service;

import it.intersistemi.corsojava.amazon.dao.model.Order;

public interface OrdersService {
	Order readOrder (Integer orderNumber);
	Iterable<Order> orderList();
	Iterable<Order> orderList(String username);
	int createOrders (Order order);
}