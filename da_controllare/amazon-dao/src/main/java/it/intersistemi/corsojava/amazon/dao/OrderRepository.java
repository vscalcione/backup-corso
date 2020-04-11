package it.intersistemi.corsojava.amazon.dao;

import it.intersistemi.corsojava.amazon.dao.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	Iterable<Order> findByUsername(String name);
}
