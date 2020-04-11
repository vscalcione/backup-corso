package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.SellerReview;
import it.intersistemi.corsojava.amazon.dao.model.SellerReviewPK;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class SellerReviewRowMapper implements RowMapper<SellerReview> {

	@Override
	public SellerReview mapRow(ResultSet rs, int rowNum) throws SQLException {
		SellerReview obj = new SellerReview();
		SellerReviewPK objPK = new SellerReviewPK();
		objPK.setP_iva(rs.getString("p_iva"));
		objPK.setUsername(rs.getString("username"));
		obj.setId(objPK);
		obj.setPunteggio(ResultSetUtil.getInt(rs,"punteggio"));
		obj.setRecensione(rs.getString("recensione"));
		obj.setTitolo(rs.getString("titolo"));
		return obj;
	}

}
