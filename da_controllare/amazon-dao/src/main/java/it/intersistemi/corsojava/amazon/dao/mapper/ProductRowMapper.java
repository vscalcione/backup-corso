package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.Product;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product obj = new Product();
		
		obj.setAsin(rs.getString("asin"));
		obj.setNome(rs.getString("nome"));
		obj.setDescrizione(rs.getString("descrizione"));
		obj.setMarca(rs.getString("marca"));
		obj.setModello(rs.getString("modello"));
		obj.setCategoriaId(ResultSetUtil.getInt(rs, "categoria"));
		return obj;
	}

}
