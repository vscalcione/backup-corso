package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.ProductReview;
import it.intersistemi.corsojava.amazon.dao.model.ProductReviewPK;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class ProductReviewRowMapper implements RowMapper<ProductReview>{
	@Override
	public ProductReview mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductReview obj = new ProductReview();
		ProductReviewPK objPK = new ProductReviewPK();
		objPK.setAsin(rs.getString("asin"));
		objPK.setUsername(rs.getString("username"));
		obj.setId(objPK);
		obj.setPunteggio(ResultSetUtil.getInt(rs,"punteggio"));
		obj.setRecensione(rs.getString("recensione"));
		obj.setTitolo(rs.getString("titolo"));
		return obj;
	}
}
