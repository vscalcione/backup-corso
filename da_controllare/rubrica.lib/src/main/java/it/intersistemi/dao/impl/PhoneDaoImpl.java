package it.intersistemi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.intersistemi.dao.PhoneDao;
import it.intersistemi.dao.mapper.PhoneRowMapper;
import it.intersistemi.exception.DataAccessException;
import it.intersistemi.exception.IncorrectResultSizeException;
import it.intersistemi.model.Phone;
import it.intersistemi.model.PhonePK;

public class PhoneDaoImpl extends GenericDaoImpl<Phone,PhonePK> implements PhoneDao{

	public PhoneDaoImpl(Connection conn){
		super(conn);
	}
	
	public List<Phone> findAll()throws DataAccessException{
		String query="SELECT * FROM phone;";
		try(
				Statement richiesta= getConnection().createStatement();
				ResultSet rs=richiesta.executeQuery(query);
			){
			
			List<Phone> lista=new ArrayList<Phone>();
			PhoneRowMapper mapperPhone=new PhoneRowMapper();
			while(rs.next()){
				lista.add(mapperPhone.mapRow(rs,rs.getRow()));
			}
			return lista;
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public Phone getById(PhonePK id)throws IllegalArgumentException,IncorrectResultSizeException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM email WHERE id=? AND contacts_id=?";
		ResultSet rs=null;
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(query);
			){
			PhoneRowMapper mapperPhone=new PhoneRowMapper();
			richiesta.setInt(1,id.getId());
			richiesta.setInt(2,id.getContactsId());
			rs=richiesta.executeQuery();
			if(rs.next()){
				Phone email=mapperPhone.mapRow(rs,rs.getRow());
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
	public PhonePK insert(Phone entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("telefono da inserire nullo");
		}
		String update="INSERT INTO phone (contacts_id,type,phone) "
									+ "values(?,?,?);";
		try(
				PreparedStatement richiesta = 
					getConnection().prepareStatement(update,
							Statement.RETURN_GENERATED_KEYS);
			){
			
			richiesta.setInt(1,entita.getId().getContactsId());
			richiesta.setString(2,entita.getType());
			richiesta.setString(3,entita.getPhone());
			richiesta.executeUpdate();
			
			ResultSet rs = richiesta.getGeneratedKeys();
			if(rs.next()) {
				return new PhonePK(rs.getInt("id"),entita.getId().getContactsId());
			} else {
				return null;
			}
		}
		catch(SQLException e){
			throw new DataAccessException(e.getMessage(),e);
		}
	}
	
	public boolean update(Phone entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("telefono modificante nullo");
		}
		
		String update="UPDATE phone "+
						"SET type=? "+
						"SET phone=?"+
						"WHERE id=?"+
						"AND contacts_id=?";
		try(
				PreparedStatement richiesta=getConnection().prepareStatement(update);
			){
			richiesta.setString(1,entita.getType());
			richiesta.setString(2,entita.getPhone());
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
	
	public boolean delete(Phone entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("telefono da eliminare nullo");
		}
		return deleteById(entita.getId());
	}
	
	public boolean deleteById(PhonePK id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM phone WHERE id=? AND contacts_id=?";
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
