package it.intersistemi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import it.intersistemi.model.Email;
import it.intersistemi.model.EmailPK;
import it.intersistemi.exception.*;

public class EmailRowMapper implements RowMapper<Email> {
	
	public Email mapRow(ResultSet rs, int lineaNum)throws DataAccessException{
		Email email=new Email();
		try{
			email.setId(new EmailPK(rs.getInt("id"),rs.getInt("contacts_id")));
			email.setType(rs.getString("type"));
			email.setEmail(rs.getString("email"));
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		
		return email;
	}
}
