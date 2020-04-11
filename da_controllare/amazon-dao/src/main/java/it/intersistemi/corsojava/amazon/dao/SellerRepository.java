package it.intersistemi.corsojava.amazon.dao;

import it.intersistemi.corsojava.amazon.dao.model.Seller;

public interface SellerRepository extends CrudRepository<Seller, String>{
	Iterable<Seller> findByName(String name);
}
