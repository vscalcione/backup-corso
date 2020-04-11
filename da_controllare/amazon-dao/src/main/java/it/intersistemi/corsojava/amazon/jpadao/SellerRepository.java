package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.Seller;

public interface SellerRepository extends CrudRepository<Seller, String> {
	Iterable<Seller> findByNome(String nome);
}