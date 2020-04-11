package it.intersistemi.dao.spring;

import java.util.List;

import it.intersistemi.exception.DataAccessException;
//import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.dao.ContactsDao;
import it.intersistemi.dao.mapper.ContactsRowMapper;
import it.intersistemi.model.Contacts;


public class ContactsSpringDaoImpl extends GenericSpringDaoImpl<Contacts,Integer> implements ContactsDao{

	
	public List<Contacts> findAll(){
		String query="SELECT * FROM contacts;";
		
		return getJdbcTemplate().query(query,new ContactsRowMapper());
	}
	
	@Override
	public Contacts getById(Integer id){
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM contacts WHERE id=?";
		return getJdbcTemplate().queryForObject(query,new ContactsRowMapper(),id);
	}
	
	@Override
	public Integer insert(Contacts entita){
		if(entita==null){
			throw new IllegalArgumentException("contatto da inserire nullo");
		}
		String update="INSERT INTO contacts (name,surname) "
									+ "values(:name,:surname);";
		KeyHolder chiaveAutogenerata=new GeneratedKeyHolder();
		//si potrebbe fare anche con i bean
		MapSqlParameterSource mappaValori=new MapSqlParameterSource();
		
		mappaValori.addValue("name",entita.getName());
		mappaValori.addValue("surname",entita.getSurname());
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());
		template.update(update,mappaValori,chiaveAutogenerata);
		
		return (Integer)chiaveAutogenerata.getKey();
	}
	
	@Override
	public boolean update(Contacts entita){
		if(entita==null){
			throw new IllegalArgumentException("contatto modificante nullo");
		}
		
		String update="UPDATE contacts "+
						"SET id=?, "+
						"name=?, "+
						"surname=?";
		if(getJdbcTemplate()
			.update(update,
					entita.getId(),
					entita.getName(),
					entita.getSurname()
					)<1){
			
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Contacts entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("contatto da eliminare nullo");
		}
		return deleteById(entita.getId());
	}
	
	@Override
	public boolean deleteById(Integer id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM contacts WHERE id=?;";
		if(getJdbcTemplate().update(delete,id)<1){
			return false;
		}
		return true;
	}
	
}
