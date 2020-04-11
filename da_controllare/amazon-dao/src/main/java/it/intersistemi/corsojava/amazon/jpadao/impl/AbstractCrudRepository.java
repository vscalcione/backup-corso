package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.intersistemi.corsojava.amazon.jpadao.CrudRepository;

public abstract class AbstractCrudRepository <T, ID> implements CrudRepository<T,ID> {
	@PersistenceContext
	private EntityManager em;
	
	private final Class<T> entityClass;
	
	public AbstractCrudRepository(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	protected final EntityManager getEm() {
		return em;
	}
	
	@Override
	public Iterable<T> findAll() {
		return em.createQuery("from " + this.entityClass.getName(), this.entityClass).getResultList();		
	}

	@Override
	public T findById(ID id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public ID insert(T obj) {
		em.persist(obj);
		return getPkValue(obj);
	}
	
	protected abstract ID getPkValue(T obj);

	@Override
	public boolean update(T obj) {
		T current = this.findById(this.getPkValue(obj));
		if(current != null) {
		this.executeUpdate(current, obj);
		return true;
		}else{
			return false;
		}
	}
	
	protected abstract void executeUpdate(T current, T obj);
	
	@Override
	public boolean delete(T obj) {
		em.remove(obj);
		return true;
	}
	
	@Override
	public boolean deleteById(ID id) {
		em.remove(this.findById(id));
		return true;
	}
}