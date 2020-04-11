package it.intersistemi.dao.jpa;

import java.util.List;

import it.intersistemi.jpa.model.Email;
import it.intersistemi.jpa.model.EmailPK;

public class EmailSpringJpaDaoImpl extends GenericSpringJpaDaoImpl<Email,EmailPK>{
	
	public List<Email> findAll(){
		return getEntityManager().createQuery("from email",Email.class).getResultList();
	}
	
	public Email getById(EmailPK id){
		return getEntityManager().find(Email.class,id);
	}
	
	public EmailPK insert(Email email){
		getEntityManager().persist(email);
		return email.getId();
	}
	
	public boolean update(Email email){
		getEntityManager().merge(email);
		return true;
	}
	
	public boolean delete(Email email){
		getEntityManager().remove(email);
		return true;
	}
	
	public boolean deleteById(EmailPK id){
		Email email=getById(id);
		return delete(email);
	}
	
}
