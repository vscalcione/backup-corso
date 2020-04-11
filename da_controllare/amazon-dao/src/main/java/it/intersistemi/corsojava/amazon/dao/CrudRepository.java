package it.intersistemi.corsojava.amazon.dao;

public interface CrudRepository <T, ID>{
	Iterable<T> findAll();
	T findById(ID id);
	ID insert(T obj);
	boolean update(T obj);
}
