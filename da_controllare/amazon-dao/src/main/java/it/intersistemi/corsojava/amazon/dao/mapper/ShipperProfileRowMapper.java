package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.ShipmentProfile;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class ShipperProfileRowMapper implements RowMapper<ShipmentProfile> {

	@Override
	public ShipmentProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShipmentProfile obj = new ShipmentProfile();
		obj.setCosto(rs.getDouble("costo"));
		obj.setNome(rs.getString("nome"));
		obj.setTempoSpedizione(ResultSetUtil.getInt(rs,"giorni_spedizione"));		
		return obj;
	}

}
