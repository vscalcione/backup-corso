package it.intersistemi.corsojava.users.dao;

public interface CrudRepository <T, PK>{
	Iterable <T> findAll();
	T findById (PK id);
	PK insert(T entity);
	int update(PK id, T entity);
	int deletebyId (PK id);
}