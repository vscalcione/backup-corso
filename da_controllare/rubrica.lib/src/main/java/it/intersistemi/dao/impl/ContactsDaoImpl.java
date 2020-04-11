package it.intersistemi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import it.intersistemi.model.Contacts;
import it.intersistemi.dao.ContactsDao;
import it.intersistemi.dao.mapper.ContactsRowMapper;
import it.intersistemi.exception.DataAccessException;
import it.intersistemi.exception.IncorrectResultSizeException;

public class ContactsDaoImpl extends GenericDaoImpl<Contacts,Integer> implements ContactsDao  {

	
	public ContactsDaoImpl(Connection conn){
		super(conn);
	}
	
	public List<Contacts> findAll()throws DataAccessException{
		String query="SELECT * FROM contacts;";
		try(
				Statement richiesta= getConnection().createStatement();
				ResultSet rs=richiesta.executeQuery(query);
			){
			
			List<Contacts> lista=new ArrayList<Contacts>();
			ContactsRowMapper mapperContatto=new ContactsRowMapper();
			while(rs.next()){
				lista.add(mapperContatto.mapRow(rs,rs.getRow()));
			}
			return lista;
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public Contacts getById(Integer id)throws IllegalArgumentException,IncorrectResultSizeException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM contacts WHERE id=";
		query=query+id+";";
		try(
				Statement richiesta=getConnection().createStatement();
				ResultSet rs=richiesta.executeQuery(query);
			){
			ContactsRowMapper mapperContatto=new ContactsRowMapper();
			if(rs.next()){
				Contacts contatto=mapperContatto.mapRow(rs,rs.getRow());
				return contatto;
			}
			else{
				throw new IncorrectResultSizeException(1,0);
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public Integer insert(Contacts entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("contatto da inserire nullo");
		}
		String update="INSERT INTO contacts (name,surname) "
									+ "values(?,?);";
		try(
				PreparedStatement richiesta = 
					getConnection().prepareStatement(update,
							Statement.RETURN_GENERATED_KEYS);
			){
			
			richiesta.setString(1,entita.getName());
			richiesta.setString(2,entita.getSurname());
			richiesta.executeUpdate();
			
			ResultSet rs = richiesta.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt("id");
			} else {
				return null;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public boolean update(Contacts entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("contatto modificante nullo");
		}
		
		String update="UPDATE contacts "+
						"SET name=? "+
						"SET surname=?"+
						"WHERE id=?;";
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(update);
			){
			richiesta.setString(1,entita.getName());
			richiesta.setString(2,entita.getSurname());
			richiesta.setInt(3,entita.getId());
			if(richiesta.executeUpdate()==0){
				return false;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
		return true;
	}
	
	public boolean delete(Contacts entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("contatto da eliminare nullo");
		}
		return deleteById(entita.getId());
	}
	
	public boolean deleteById(Integer id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM contacts WHERE id=?;";
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(delete);
			){
			richiesta.setInt(1,id);
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