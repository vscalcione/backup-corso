package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.ProductOrder;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrderPK;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class ProductOrderRowMapper implements RowMapper<ProductOrder>{

	@Override
	public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductOrder obj = new ProductOrder();
		ProductOrderPK objPK = new ProductOrderPK();
		objPK.setAsin(rs.getString("asin"));
		objPK.setNumeroOrdine(ResultSetUtil.getInt(rs,"numero_ordine"));
		objPK.setpIva(rs.getString("p_iva"));
		obj.setNomeProfiloSpedizione(rs.getString("Nome_profilo_spedizione"));
		obj.setPrezzoAcquisto(ResultSetUtil.getDouble(rs,"prezzo_acquisto"));
		obj.setQuantita(ResultSetUtil.getInt(rs,"quantita"));
		obj.setSconto(ResultSetUtil.getInt(rs,"sconto"));
		obj.setId(objPK);
		return obj;
	}

}
