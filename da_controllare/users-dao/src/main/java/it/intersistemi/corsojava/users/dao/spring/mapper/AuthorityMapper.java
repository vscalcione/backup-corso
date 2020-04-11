package it.intersistemi.corsojava.users.dao.spring.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

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

