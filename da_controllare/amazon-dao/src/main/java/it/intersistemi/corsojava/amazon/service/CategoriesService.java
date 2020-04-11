package it.intersistemi.corsojava.amazon.service;

import it.intersistemi.corsojava.amazon.dao.model.Category;

public interface CategoriesService {
	void addCategory(Category category);
	void modifyCategory(Category category);
	void deleteCategory (Category category);
	Iterable<Category> categoryList();
	Iterable<Category> categoryList(Integer categories);
}