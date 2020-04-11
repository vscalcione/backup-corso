package it.intersistemi.corsojava.users.dao.spring.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.users.dao.UserRepository;
import it.intersistemi.corsojava.users.dao.spring.mapper.AuthorityMapper;
import it.intersistemi.corsojava.users.dao.spring.mapper.UserMapper;
import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String QUERY_LISTAUTHORITIES = " SELECT a.* "
			+ " FROM AUTHORITIES a"
			+ " JOIN USER_AUTHORITIES ua ON ua.AUTHORITY = a.AUTHORITY"
			+ " WHERE ua.USER_NAME = ? ";
	private static final String QUERY_DELETE_GROUPAUTHORITIES = " DELETE USER_AUTHORITIES WHERE USER_NAME = ? AND AUTHORITY = ? ";
	private static final String QUERY_INSERT_GROUPAUTHORITIES = " INSERT INTO USER_AUTHORITIES (USER_NAME, AUTHORITY) "
			+ " VALUES (?, ?) ";
	private static final String QUERY_DELETE = " DELETE USERS WHERE USER_NAME = ? ";
	private static final String QUERY_UPDATE = " UPDATE USERS SET USER_NAME = ?, PASSWORD = ?, ENABLED =? "
			+ " WHERE USER_ID = ? ";
	private static final String QUERY_FIND_ALL = " SELECT * FROM USERS ";
	private static final String QUERY_FIND_BY_ID = " SELECT * FROM USERS WHERE USER_NMAE = ? ";
	private static final String QUERY_INSERT = " INSERT INTO USERS (USER_NAME, PASSWORD, ENABLED) "
			+ " VALUES (:userName, :password, :enabled ";
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate parameterJdbcTemplate;

	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Iterable<User> findAll() {
		return this.jdbcTemplate.query(QUERY_FIND_ALL,new UserMapper());
	}

	@Override
	public User findById(Integer id) {
		return this.jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new UserMapper(), id);
	}

	@Override
	public Integer insert(User entity) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		this.parameterJdbcTemplate.update(QUERY_INSERT, paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public int update(Integer id, User entity) {
		return this.jdbcTemplate.update(QUERY_UPDATE, entity.getUserName(), entity.getPassword(), entity.isEnabled(), id);
	}

	@Override
	public int deletebyId(Integer id) {
		return this.jdbcTemplate.update(QUERY_DELETE, id);
	}
	
	//GROUP-AUTHORITIES

	@Override
	public void addAuthority(String userName, String authority) {
		this.jdbcTemplate.update(QUERY_INSERT_GROUPAUTHORITIES, userName, authority);
	}

	@Override
	public void removeAuthority(String userName, String authority) {
		this.jdbcTemplate.update(QUERY_DELETE_GROUPAUTHORITIES, userName, authority);
	}

	@Override
	public List<Authority> listAuthorities(String userName) {
		return this.jdbcTemplate.query(QUERY_LISTAUTHORITIES, new AuthorityMapper(), userName);
	}
}