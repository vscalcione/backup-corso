package it.intersistemi.dao.impl;

import java.sql.Connection;

import it.intersistemi.dao.GenericDao;

public abstract class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

	private Connection connection;
	
	public GenericDaoImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	
	protected final Connection getConnection() {
		return connection;
	}
}
