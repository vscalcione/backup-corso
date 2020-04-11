package it.intersistemi.corsojava.users.dao.spring.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.users.dao.GroupRepository;
import it.intersistemi.corsojava.users.dao.spring.mapper.AuthorityMapper;
import it.intersistemi.corsojava.users.dao.spring.mapper.GroupMapper;
import it.intersistemi.corsojava.users.dao.spring.mapper.UserMapper;
import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.Group;
import it.intersistemi.corsojava.users.model.User;

@Repository
public class GroupRepositoryImpl implements GroupRepository {
	
	private static final String QUERY_DELETE_GROUPAUTHORITIES = "DELETE GROUP_AUTHORITIES WHERE GROUP_NAME = ? AND AUTHORITY = ?";
	private static final String QUERY_INSERT_GROUPAUTHORITIES = "INSERT INTO GROUP_AUTHORITIES (GROUP_NAME, DESCRIPTION) VALUES (? , ?)";
	//dichiarazione di variabili statiche che contengono le varie query da eseguire
	private static final String QUERY_FIND_ALL = "SELECT * FROM GROUPS";
	private static final String QUERY_FIND_BY_ID = "SELECT * FROM GROUPS WHERE GROUP_NAME = ? ";
	private static final String QUERY_INSERT = "INSERT INTO GROUPS (GROUP_NAME, DESCRIPTION) VALUES (?, ?)";
	private static final String QUERY_UPDATE = "UPDATE GROUPS SET GROUP_NAME = ?, DESCRIPTION = ? WHERE DESCRIPTION = ?";
	private static final String QUERY_DELETE = "DELETE AUTHORITIES WHERE AUTHORITY = ?";

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GroupRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
		
	@Override
	public Iterable<Group> findAll() {
		return this.jdbcTemplate.query(QUERY_FIND_ALL, new GroupMapper());
	}

	@Override
	public Group findById(String id) {
		return this.jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new GroupMapper(), id);
	}

	@Override
	public String insert(Group entity) {
		this.jdbcTemplate.update(QUERY_INSERT, entity.getGroupName(), entity.getDescription());
		return entity.getGroupName();
	}

	@Override
	public int update(String id, Group entity) {
		return this.jdbcTemplate.update(QUERY_UPDATE, entity.getGroupName(), entity.getDescription(), id);
	}

	@Override
	public int deletebyId(String id) {
		return this.jdbcTemplate.update(QUERY_DELETE, id);
	}

	//GROUP-AUTHORITIES
	@Override
	public void addAuthority(String groupName, String authority) {
		this.jdbcTemplate.update(QUERY_INSERT_GROUPAUTHORITIES, groupName, authority);
	}

	@Override
	public void removeAuthority(String groupName, String authority) {
		this.jdbcTemplate.update(QUERY_DELETE_GROUPAUTHORITIES, groupName, authority);
	}

	@Override
	public List<Authority> listAuthorities(String groupName) {
		return this.jdbcTemplate.query(" SELECT a.* "
				+ " FROM AUTHORITIES a"
				+ " JOIN GROUP_AUTHORITIES ga ON ga.AUTHORITY = a.AUTHORITY "
				+ " WHERE ga.GROUP_NAME = ? ", new AuthorityMapper(), groupName);
	}

	@Override
	public void addUser(String groupName, String username) {
		this.jdbcTemplate.update("INSERT INTO GROUP_MEMBERS (USER_NAME, GROUP_NAME) VALUES (?, ?)", username, groupName);
	}

	@Override
	public void removeUser(String groupName, String username) {
		this.jdbcTemplate.update("DELETE GROUP_MEMBERS WHERE USER_NAME = ? AND GROUP_NAME = ?) ", username, groupName);
	}

	@Override
	public List<User> listUsers(String groupName) {
		return this.jdbcTemplate.query("SELECT u.* "+
	" FROM USERS u "+
	" JOIN GROUP_MEMBERS gm ON gm.USER_NAME = u.USER_NAME"+ 
	" WHERE gm.GROUP_NAME = ? ", new UserMapper(), groupName);
	}
}
