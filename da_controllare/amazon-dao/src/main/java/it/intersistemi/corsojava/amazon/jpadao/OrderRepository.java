package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	Iterable<Order> findByUsername(String nome);
}
