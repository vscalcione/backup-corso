package it.intersistemi.dao.spring;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.dao.GenericDao;

public abstract class GenericSpringDaoImpl<T, PK> implements GenericDao<T, PK> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
}
