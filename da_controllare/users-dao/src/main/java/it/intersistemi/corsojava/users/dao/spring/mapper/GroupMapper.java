package it.intersistemi.corsojava.users.dao.spring.mapper;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.corsojava.users.model.Group;

public class GroupMapper implements RowMapper<Group>{
	public Group mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException{
		Group entity = new Group();
		//Estrarre i valori da un result set
		entity.setGroupName(rs.getString("GROUP_NAME"));
		entity.setDescription(rs.getString("DESCRIPTION"));
		return entity;
	}
}
