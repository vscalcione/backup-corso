package it.intersistemi.dao.spring;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.dao.mapper.PhoneRowMapper;
import it.intersistemi.exception.DataAccessException;
import it.intersistemi.dao.PhoneDao;
import it.intersistemi.model.Phone;
import it.intersistemi.model.PhonePK;

public class PhoneSpringDaoImpl extends GenericSpringDaoImpl<Phone,PhonePK> implements PhoneDao{

	
	public List<Phone> findAll(){
		String query="SELECT * FROM phone;";
		
		return getJdbcTemplate().query(query,new PhoneRowMapper());
	}
	
	@Override
	public Phone getById(PhonePK id){
		if(id==null){
			throw new IllegalArgumentException("l'id non può essere null");
		}
		String query="SELECT * FROM phone WHERE id=? AND contacts_id=?";
		return getJdbcTemplate().queryForObject(query,new PhoneRowMapper(),id.getId(),id.getContactsId());
	}
	
	@Override
	public PhonePK insert(Phone entita){
		if(entita==null){
			throw new IllegalArgumentException("telefono da inserire nullo");
		}
		String update="INSERT INTO phone (contacts_id,type,phone) "
									+ "values(:contactsId,:type,:phone);";
		KeyHolder chiaveAutogenerata=new GeneratedKeyHolder();
		MapSqlParameterSource mappaValori=new MapSqlParameterSource();
		
		mappaValori.addValue("contactsId",entita.getId().getContactsId());
		mappaValori.addValue("type",entita.getType());
		mappaValori.addValue("phone",entita.getPhone());
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());
		template.update(update,mappaValori,chiaveAutogenerata);
		
		return new PhonePK((Integer)chiaveAutogenerata.getKey(),entita.getId().getContactsId());
	}
	
	@Override
	public boolean update(Phone entita){
		if(entita==null){
			throw new IllegalArgumentException("telefono modificante nullo");
		}
		
		String update="UPDATE phone "+
						"SET id=?, "+
						"contacts_id=?, "+
						"type=?, "+
						"phone=?";
		if(getJdbcTemplate()
			.update(update,
					entita.getId().getId(),
					entita.getId().getContactsId(),
					entita.getType(),
					entita.getPhone()
					)<1){
			
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Phone entita)throws IllegalArgumentException,DataAccessException{
		if(entita==null){
			throw new IllegalArgumentException("telefono da eliminare nullo");
		}
		return deleteById(entita.getId());
	}
	
	@Override
	public boolean deleteById(PhonePK id)throws IllegalArgumentException,DataAccessException{
		if(id==null){
			throw new IllegalArgumentException("id per l'eliminazione nullo");
		}
		String delete="DELETE FROM phone WHERE id=? AND contacts_id=?";
		if(getJdbcTemplate().update(delete,id.getId(),id.getContactsId())<1){
			return false;
		}
		return true;
	}
}
