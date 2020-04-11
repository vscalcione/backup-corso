package it.intersistemi.corsojava.users.dao.spring.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.users.dao.AuthorityRepository;
import it.intersistemi.corsojava.users.dao.spring.mapper.AuthorityMapper;
import it.intersistemi.corsojava.users.model.Authority;

@Repository
public class AuthorityRepositoryImpl implements AuthorityRepository {
	
	//dichiarazione di variabili statiche che contengono le varie query da eseguire
	private static final String QUERY_FIND_ALL = "SELECT * FROM AUTHORITIES";
	private static final String QUERY_FIND_BY_ID = "SELECT * FROM AUTHORITIES WHERE AUTHORITY = ? ";
	private static final String QUERY_INSERT = "INSERT INTO AUTHORITIES (AUTHORITY, DESCRIPTION) VALUES (?, ?)";
	private static final String QUERY_UPDATE = "UPDATE AUTHORITIES SET AUTHORITY = ?, DESCRIPTION = ? WHERE AUTHORITY = ?";
	private static final String QUERY_DELETE = "DELETE AUTHORITIES WHERE AUTHORITY = ?";
	
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate parameterJdbcTemplate;
	
	@Autowired
	public AuthorityRepositoryImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource); 
	}

	@Override
	public Iterable<Authority> findAll() {
		return this.jdbcTemplate.query(QUERY_FIND_ALL, new AuthorityMapper());
	}

	@Override
	public Authority findById(String id) {
		return this.jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new AuthorityMapper(), id);
	}

	@Override
	public String insert(Authority entity) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		parameterJdbcTemplate.update("INSERT INTO AUTHORITIES (AUTHORITIES, DESCRIPTION) VALUES "
				+ "(:authority, :description)", paramSource);
		//return this.jdbcTemplate.update(QUERY_INSERT, entity.getAuthority(), entity.getDescription());
		return entity.getAuthority();
	}

	@Override
	public int update(String id, Authority entity) {
		return this.jdbcTemplate.update(QUERY_UPDATE, entity.getAuthority(), entity.getDescription(), id);
	}

	@Override
	public int deletebyId(String id) {
		return this.jdbcTemplate.update(QUERY_DELETE, id);
	}
}