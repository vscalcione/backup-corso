package it.intersistemi.corsojava.users.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import it.intersistemi.corsojava.users.dao.DataAccessException;
import it.intersistemi.corsojava.users.dao.GroupRepository;
import it.intersistemi.corsojava.users.dao.spring.mapper.GroupMapper;
import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.Group;
import it.intersistemi.corsojava.users.model.User;

public class GroupRepositoryImpl implements GroupRepository {
	private static final String QUERY_FIND_ALL = "SELECT * FROM GROUP";
	private static final String QUERY_FIND_BY_ID = "SELECT * FROM GROUPS WHERE GROUP_NAME = ? ";
	private DataSource dataSource;
	public GroupRepositoryImpl(BasicDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Override
	public Iterable<Group> findAll() {
			try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_FIND_ALL);
			ResultSet rs = ps.executeQuery();){
			return (Iterable<Group>) new GroupMapper().mapRow(rs, 0);
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}
	@Override
	public Group findById(String id) {
			try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_FIND_BY_ID);){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new GroupMapper().mapRow(rs, rs.getRow());
			}
			else {
				return null;
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}
	@Override
	public int insert(Group entity) {
			try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO GROUPS (GROUP_NAME, DESCRIPTION) VALUES (?, ?)");){
			ps.setString(1, entity.getGroupName());
			ps.setString(2, entity.getDescription());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}


	@Override
	public int update(Group entity) {
		try(Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE GROUPS SET GROUP_NAME = ?, DESCRIPTION = ? WHERE GROUP_NAME = ?");){
			ps.setString(1, entity.getGroupName());
			ps.setString(2,  entity.getDescription());
			
			ps.setString(3, entity.getGroupName());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public int deletebyId(String id) {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE GROUPS WHERE GROUP_NAME = ?");){
				ps.setString(1, id);
				return ps.executeUpdate();
			}catch(SQLException e) {
				throw new DataAccessException(e);
			}
	}

	@Override
	public void addAuthority(String groupName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAuthority(String groupName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Authority> listAuthorities(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String groupName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String groupName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> listUsers(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Group entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
