package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.ProductShipmentProfile;

public class ProductProfileShipmentRowMapper implements RowMapper<ProductShipmentProfile> {

	@Override
	public ProductShipmentProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductShipmentProfile obj = new ProductShipmentProfile();
		obj.setAsin(rs.getString("asin"));
		obj.setNomeSpedizione(rs.getString("nome_spedizione"));
		obj.setP_iva(rs.getString("p_iva"));
		return obj;
	}
	

}
