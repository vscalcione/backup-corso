package it.intersistemi.corsojava.amazon.service;

import it.intersistemi.corsojava.amazon.dao.model.Product;

public interface ProductsService {
	void addProduct(Product product);
	void modifyProduct(Product product);
	void deleteProduct(Product product);
	Iterable<Product> productList();
	Product readProduct(String asin);
	Iterable<Product> searchProduct (String searchString, String marca, Integer categoriaId);
}