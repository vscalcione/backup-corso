package it.intersistemi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//import it.intersistemi.dao.RowMapper;
import it.intersistemi.model.Contacts;
import it.intersistemi.exception.*;

public class ContactsRowMapper implements RowMapper<Contacts>{
	
	public Contacts mapRow(ResultSet rs, int lineaNum) throws DataAccessException{
		Contacts contatto=new Contacts();
		try{
			contatto.setId(rs.getInt("id"));
			contatto.setName(rs.getString("name"));
			contatto.setSurname(rs.getString("surname"));
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		
		return contatto;
	}
}
