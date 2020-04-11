package it.intersistemi.corsojava.users.dao.jdbc.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.Group;

public class GroupMapper implements RowMapper<Group>{
	public Group mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException{
		Group entity = new Group();
		//Estrarre i valori da un result set
		entity.setGroupName("GROUP_NAME");
		entity.setDescription("DESCRIPTION");
		return entity;
	}
}
