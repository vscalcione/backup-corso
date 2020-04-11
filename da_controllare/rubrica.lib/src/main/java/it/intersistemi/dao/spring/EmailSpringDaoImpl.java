package it.intersistemi.dao.spring;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.dao.EmailDao;
import it.intersistemi.dao.mapper.EmailRowMapper;
import it.intersistemi.exception.DataAccessException;
import it.intersistemi.model.Email;
import it.intersistemi.model.EmailPK;

public class EmailSpringDaoImpl extends GenericSpringDaoImpl<Email,EmailPK> implements EmailDao{
	
	public List<Email> findAll(){
		String query="SELECT * FROM email;";
		
		return getJdbcTemplate().query(query,new EmailRowMapper());
	}
	
	@Override
	public Email getById(EmailPK id){
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM email WHERE id=? AND contacts_id=?";
		return getJdbcTemplate().queryForObject(query,new EmailRowMapper(),id.getId(),id.getContactsId());
	}
	
	@Override
	public EmailPK insert(Email entita){
		if(entita==null){
			throw new IllegalArgumentException("email da inserire nullo");
		}
		String update="INSERT INTO email (contacts_id,type,email) "
									+ "values(:contactsId,:type,:email);";
		KeyHolder chiaveAutogenerata=new GeneratedKeyHolder();
		MapSqlParameterSource mappaValori=new MapSqlParameterSource();
		
		mappaValori.addValue("contactsId",entita.getId().getContactsId());
		mappaValori.addValue("type",entita.getType());
		mappaValori.addValue("email",entita.getEmail());
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());
		template.update(update,mappaValori,chiaveAutogenerata);
		
		return new EmailPK((Integer)chiaveAutogenerata.getKey(),entita.getId().getContactsId());
	}
	
	@Override
	public boolean update(Email entita){
		if(entita==null){
			throw new IllegalArgumentException("email modificante nullo");
		}
		
		String update="UPDATE email "+
						"SET id=?, "+
						"contacts_id=?, "+
						"type=?, "+
						"email=?";
		if(getJdbcTemplate()
			.update(update,
					entita.getId().getId(),
					entita.getId().getContactsId(),
					entita.getType(),
					entita.getEmail()
					)<1){
			
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Email entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("email da eliminare nullo");
		}
		return deleteById(entita.getId());
	}
	
	@Override
	public boolean deleteById(EmailPK id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM email WHERE id=? AND contacts_id=?";
		if(getJdbcTemplate().update(delete,id.getId(),id.getContactsId())<1){
			return false;
		}
		return true;
	}
}
