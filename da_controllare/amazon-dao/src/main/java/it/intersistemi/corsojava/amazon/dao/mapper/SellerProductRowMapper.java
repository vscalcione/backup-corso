package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.SellerProduct;
import it.intersistemi.corsojava.amazon.dao.model.SellerProductPK;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class SellerProductRowMapper implements RowMapper<SellerProduct> {

	@Override
	public SellerProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		SellerProduct obj = new SellerProduct();
		SellerProductPK objPK = new SellerProductPK();
		objPK.setAsin(rs.getString("asin"));
		objPK.setpIva(rs.getString("p_iva"));
		obj.setId(objPK);		
		obj.setPezziDisponibili(ResultSetUtil.getInt(rs,"pezzi_disponibili"));		
		obj.setPrezzo(ResultSetUtil.getDouble(rs,"prezzo"));		
		return obj;
	}

}
