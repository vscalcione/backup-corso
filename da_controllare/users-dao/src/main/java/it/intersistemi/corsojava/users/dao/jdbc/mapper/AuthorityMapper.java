package it.intersistemi.corsojava.users.dao.jdbc.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.users.model.Authority;

public class AuthorityMapper implements RowMapper<Authority>{
	public Authority mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException{
		Authority entity = new Authority();
		//Estrarre i valori da un result set
		entity.setAuthority(rs.getString("AUTHORITY"));
		entity.setDescription(rs.getString("DESCRIPTION"));
		return entity;
	}
}
