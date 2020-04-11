package it.intersistemi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.model.Phone;
import it.intersistemi.model.PhonePK;
import it.intersistemi.exception.*;

public class PhoneRowMapper implements RowMapper<Phone>{
	
	public Phone mapRow(ResultSet rs,int lineaNum) throws DataAccessException{
		Phone telefono=new Phone();
		try{
			telefono.setId(new PhonePK(rs.getInt("id"),rs.getInt("contacts_id")));
			telefono.setType(rs.getString("type"));
			telefono.setPhone(rs.getString("phone"));
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		
		return telefono;
	}
	
}