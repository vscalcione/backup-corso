package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	Iterable<Product> findByNome(String nome);
}