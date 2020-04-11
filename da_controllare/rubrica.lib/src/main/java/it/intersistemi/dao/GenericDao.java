package it.intersistemi.dao;

import java.util.List;

public interface GenericDao<T, PK> {
	
	public List<T> findAll();
	
	public T getById(PK id);
	
	public PK insert(T entity);
	
	public boolean update(T entity);
	
	public boolean delete(T entity);
	
	public boolean deleteById(PK id);
	
}
