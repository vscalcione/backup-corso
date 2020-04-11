package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.Category;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category obj = new Category();
		obj.setId(ResultSetUtil.getInt(rs,"id"));
		obj.setIdPadre(ResultSetUtil.getInt(rs,"id_padre"));
		obj.setNome(rs.getString("nome"));		
		return obj;
	}

}
