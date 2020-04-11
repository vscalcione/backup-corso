package it.intersistemi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import it.intersistemi.model.Email;
import it.intersistemi.model.EmailPK;
import it.intersistemi.dao.EmailDao;
import it.intersistemi.dao.mapper.EmailRowMapper;
import it.intersistemi.exception.DataAccessException;
import it.intersistemi.exception.IncorrectResultSizeException;

public class EmailDaoImpl extends GenericDaoImpl<Email,EmailPK> implements EmailDao{
	public EmailDaoImpl(Connection conn){
		super(conn);
	}
	
	public List<Email> findAll()throws DataAccessException{
		String query="SELECT * FROM email;";
		try(
				Statement richiesta= getConnection().createStatement();
				ResultSet rs=richiesta.executeQuery(query);
			){
			
			List<Email> lista=new ArrayList<Email>();
			EmailRowMapper mapperEmail=new EmailRowMapper();
			while(rs.next()){
				lista.add(mapperEmail.mapRow(rs,rs.getRow()));
			}
			return lista;
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public Email getById(EmailPK id)throws IllegalArgumentException,IncorrectResultSizeException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM email WHERE id=? AND contacts_id=?";
		ResultSet rs=null;
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(query);
			){
			EmailRowMapper mapperEmail=new EmailRowMapper();
			richiesta.setInt(1,id.getId());
			richiesta.setInt(2,id.getContactsId());
			rs=richiesta.executeQuery();
			if(rs.next()){
				Email email=mapperEmail.mapRow(rs,rs.getRow());
				return email;
			}
			else{
				throw new IncorrectResultSizeException(1,0);
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		finally{
			try{
				rs.close();
			}
			catch(SQLException e){
				throw new DataAccessException(e.getMessage(),e);
			}
		}
	}
	
	public EmailPK insert(Email entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("email da inserire nulla");
		}
		String update="INSERT INTO email (contacts_id,type,email) "
									+ "values(?,?,?);";
		try(
				PreparedStatement richiesta = 
					getConnection().prepareStatement(update,
							Statement.RETURN_GENERATED_KEYS);
			){
			
			richiesta.setInt(1,entita.getId().getContactsId());
			richiesta.setString(2,entita.getType());
			richiesta.setString(3,entita.getEmail());
			richiesta.executeUpdate();
			
			ResultSet rs = richiesta.getGeneratedKeys();
			if(rs.next()) {
				return new EmailPK(rs.getInt("id"),entita.getId().getContactsId());
			} else {
				return null;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public boolean update(Email entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("email modificante nulla");
		}
		
		String update="UPDATE email "+
						"SET type=? "+
						"SET email=?"+
						"WHERE id=?"+
						"AND contacts_id=?";
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(update);
			){
			richiesta.setString(1,entita.getType());
			richiesta.setString(2,entita.getEmail());
			richiesta.setInt(3,entita.getId().getId());
			richiesta.setInt(3,entita.getId().getContactsId());
			if(richiesta.executeUpdate()==0){
				return false;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		return true;
	}
	
	public boolean delete(Email entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("email da eliminare nulla");
		}
		return deleteById(entita.getId());
	}
	
	public boolean deleteById(EmailPK id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM email WHERE id=? AND contacts_id=?";
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(delete);
			){
			richiesta.setInt(1,id.getId());
			richiesta.setInt(2,id.getContactsId());
			if(richiesta.executeUpdate()==0){
				return false;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		return true;
	}
	
}
