package it.intersistemi.corsojava.amazon.dao;

import it.intersistemi.corsojava.amazon.dao.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	Iterable<Category> findChildrenCategories(Integer id);
	Iterable<Category> findRootCategories();
}
