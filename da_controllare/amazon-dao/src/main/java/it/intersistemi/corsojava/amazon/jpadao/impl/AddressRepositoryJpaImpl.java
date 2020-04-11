package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.AddressRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.Address;

@Transactional
@Repository
public class AddressRepositoryJpaImpl extends AbstractCrudRepository<Address, Integer> implements AddressRepository {

	@PersistenceContext
	private EntityManager em;
	
	public AddressRepositoryJpaImpl() {
		super(Address.class);		
	}

	@Override
	public Iterable<Address> findByUsername(String username) {
		return em.createQuery("from Indirizzo i where i.username = :username", Address.class)
			.setParameter("username", username)
			.getResultList();
	}

	@Override
	protected Integer getPkValue(Address obj) {
		return obj.getId();
	}

	@Override
	protected void executeUpdate(Address current, Address obj) {
		current.setCap(obj.getCap());
		current.setCitta(obj.getCitta());
		current.setId(obj.getId());
		current.setNazione(obj.getNazione());
		current.setNominativo(obj.getNominativo());
		current.setNumeroTelefono(obj.getNumeroTelefono());
		current.setProvincia(obj.getProvincia());
		current.setUtente(obj.getUtente());
		current.setVia(obj.getProvincia());		
	}
}
