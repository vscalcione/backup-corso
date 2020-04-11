package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.Seller;

public class SellerRowMapper implements RowMapper<Seller> {

	@Override
	public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
		Seller obj = new Seller();
		obj.setNazione(rs.getString("nazione"));
		obj.setNome(rs.getString("nome"));
		obj.setpIva(rs.getString("p_iva"));
		return obj;
	}

}
