package it.intersistemi.corsojava.users.dao.spring.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.corsojava.users.model.User;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException{
		User entity = new User();
		
		//Estrarre i valori da un result set
		entity.setUserID(rs.getInt("USER_ID"));
		entity.setUserName(rs.getString("USER_NAME"));
		entity.setPassword(rs.getString("PASSWORD"));
		entity.setEnabled(rs.getBoolean("ENABLED"));
		return entity;
	}
}
