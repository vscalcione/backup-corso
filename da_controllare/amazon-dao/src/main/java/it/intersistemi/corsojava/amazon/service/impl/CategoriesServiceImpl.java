package it.intersistemi.corsojava.amazon.service.impl;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.amazon.dao.CategoryRepository;
import it.intersistemi.corsojava.amazon.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	@Autowired
	private CategoryRepository categoriaRepository;

	@Override
	public void addCategory(it.intersistemi.corsojava.amazon.dao.model.Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCategory(it.intersistemi.corsojava.amazon.dao.model.Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(it.intersistemi.corsojava.amazon.dao.model.Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<it.intersistemi.corsojava.amazon.dao.model.Category> categoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<it.intersistemi.corsojava.amazon.dao.model.Category> categoryList(Integer categories) {
		// TODO Auto-generated method stub
		return null;
	}
}