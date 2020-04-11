package it.intersistemi.corsojava.amazon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.amazon.dao.CategoryRepository;
import it.intersistemi.corsojava.amazon.dao.model.Category;
import it.intersistemi.corsojava.amazon.service.CategoriesService;

@Service
public class CategoryServiceImpl implements CategoriesService{
	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		// TODO Auto-generated method stub
	}

	public void modifyCategory(Category category) {
		// TODO Auto-generated method stub
	}

	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
	}

	public Iterable<Category> categoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Category> categoryList(Integer categories) {
		// TODO Auto-generated method stub
		return null;
	}
}