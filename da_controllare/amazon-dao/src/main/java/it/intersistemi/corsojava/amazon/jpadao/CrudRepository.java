package it.intersistemi.corsojava.amazon.jpadao;

public interface CrudRepository<T, ID> {
	Iterable<T> findAll();	
	T findById(ID id);
	ID insert(T obj);
	boolean update(T obj);
	boolean delete(T obj);
	boolean deleteById (ID id);
}