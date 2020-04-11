package it.intersistemi.corsojava.users.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import it.intersistemi.corsojava.users.dao.AuthorityRepository;
import it.intersistemi.corsojava.users.dao.DataAccessException;
import it.intersistemi.corsojava.users.dao.jdbc.mapper.AuthorityMapper;
import it.intersistemi.corsojava.users.model.Authority;

public class AuthorityRepositoryImpl implements AuthorityRepository {
	private static final String QUERY_FIND_ALL = "SELECT * FROM AUTHORITIES";
	private static final String QUERY_FIND_BY_ID = "SELECT * FROM AUTHORITIES WHERE AUTHORITY = ? ";
	private static final String QUERY_INSERT = "INSERT INTO AUTHORITIES (AUTHORITY, DESCRIPTION) VALUES (?, ?)";
	private static final String QUERY_UPDATE = "UPDATE AUTHORITIES SET AUTHORITY = ?, DESCRIPTION = ? WHERE AUTHORITY = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE AUTHORITIES WHERE AUTHORITY = ?";
	private DataSource dataSource;
	public AuthorityRepositoryImpl(BasicDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Iterable<Authority> findAll() {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_FIND_ALL);
			ResultSet rs = ps.executeQuery();){
			return new AuthorityMapper().mapRowsAsList(rs);
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public Authority findById(String id) {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_FIND_BY_ID);){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new AuthorityMapper().mapRow(rs, rs.getRow());
			}
			else {
				return null;
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public String insert(Authority entity) {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_INSERT);){
			ps.setString(1, entity.getAuthority());
			ps.setString(2, entity.getDescription());
			ps.executeUpdate();
			return entity.getAuthority();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public int update(String id, Authority entity) {
		try(Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(QUERY_UPDATE);){
			ps.setString(1, entity.getAuthority());
			ps.setString(2,  entity.getDescription());
			
			ps.setString(3, id);
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public int deletebyId(String id) {
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(QUERY_DELETE_BY_ID);){
			ps.setString(1, id);
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
	}
}