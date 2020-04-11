package it.intersistemi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.model.Entity;

/**
 * Interfaccia RowMapper
 * Implementare questa interfaccia per implementare un mapper che crea un oggetto a partire da un resultset
 * 
 * Esempio di utilizzo
 * <pre>
 * RowMapper<Phone> phoneRowMapper = new PhoneRowMapper();
 * ResultSet rs = ...
 * while(rs.next()) {
 *     Phone phone = phoneRowMapper.mapRow(rs, rs.getRow());
 *     ...
 * }
 * 
 * </pre>
 * @author ivavis
 *
 * @param <T>
 */
public interface RowMapper<T extends Entity<?>> {
	
	/**
	 * @param rs
	 * @param rowNum
	 * @return
	 * @throws SQLException
	 */
	public T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
