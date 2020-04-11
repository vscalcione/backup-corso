package it.intersistemi.dao.jpa;

import java.util.List;

import it.intersistemi.jpa.model.Contact;

public class ContactsSpringJpaDaoImpl extends GenericSpringJpaDaoImpl<Contact,Integer>{
	
	public List<Contact> findAll(){
		return getEntityManager().createQuery("from contacts",Contact.class).getResultList();
	}
	
	public Contact getById(Integer id){
		return getEntityManager().find(Contact.class,id);
	}
	
	public Integer insert(Contact contatto){
		getEntityManager().persist(contatto);
		return contatto.getId();
	}
	
	public boolean update(Contact contatto){
		getEntityManager().merge(contatto);
		return true;
	}
	
	public boolean delete(Contact contatto){
		getEntityManager().remove(contatto);
		return true;
	}
	
	public boolean deleteById(Integer id){
		Contact contatto=getById(id);
		return delete(contatto);
	}
	
}
