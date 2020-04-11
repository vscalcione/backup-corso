package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.Address;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address obj = new Address();
		obj.setCap(rs.getString("cap"));
		obj.setCitta(rs.getString("citta"));
		obj.setId(ResultSetUtil.getInt(rs,"id"));
		obj.setNazione(rs.getString("nazione"));
		obj.setNominativo(rs.getString("nominativo"));
		obj.setNumeroTelefono(rs.getString("numero_di_telefono"));
		obj.setProvincia(rs.getString("provincia"));
		obj.setUsername(rs.getString("username"));
		obj.setVia(rs.getString("via"));
		return obj;
	}

}
