package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User obj = new User();
		obj.setEmail(rs.getString("email"));
		obj.setPassword(rs.getString("password"));
		obj.setUsername(rs.getString("username"));		
		return obj;
	}

}
