package it.intersistemi.dao.jpa;

import java.util.List;

import it.intersistemi.jpa.model.Phone;
import it.intersistemi.jpa.model.PhonePK;

public class PhoneSpringJpaDaoImpl extends GenericSpringJpaDaoImpl<Phone,PhonePK> {
	
	public List<Phone> findAll(){
		return getEntityManager().createQuery("from phone",Phone.class).getResultList();
	}
	
	public Phone getById(PhonePK id){
		return getEntityManager().find(Phone.class,id);
	}
	
	public PhonePK insert(Phone telefono){
		getEntityManager().persist(telefono);
		return telefono.getId();
	}
	
	public boolean update(Phone telefono){
		getEntityManager().merge(telefono);
		return true;
	}
	
	public boolean delete(Phone telefono){
		getEntityManager().remove(telefono);
		return true;
	}
	
	public boolean deleteById(PhonePK id){
		Phone telefono=getById(id);
		return delete(telefono);
	}
	
}
