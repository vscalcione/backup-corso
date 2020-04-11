package it.intersistemi.dao.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.intersistemi.dao.GenericDao;

public abstract class GenericSpringJpaDaoImpl<T, PK> implements GenericDao<T, PK> {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
