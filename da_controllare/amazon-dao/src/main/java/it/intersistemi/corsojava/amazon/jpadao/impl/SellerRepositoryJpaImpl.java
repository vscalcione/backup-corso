package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.SellerRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.Seller;

@Transactional
@Repository
public class SellerRepositoryJpaImpl extends AbstractCrudRepository<Seller, String> implements SellerRepository {

	public SellerRepositoryJpaImpl() {
		super(Seller.class);
	}

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Iterable<Seller> findByNome(String nome) {
		Seller venditore = em.find(Seller.class, nome);
		return em.createQuery("from Venditore v where v.pIva = :pIva", Seller.class)
				.setParameter("pIva", venditore)
				.getResultList();
	}

	@Override
	protected String getPkValue(Seller obj) {
		return obj.getPIva();
	}

	@Override
	protected void executeUpdate(Seller current, Seller obj) {
		current.setNazione(obj.getNazione());
		current.setNome(obj.getNome());
		current.setPIva(obj.getPIva());
		current.setRecensioni(obj.getRecensioni());
		current.setVenditori(obj.getVenditori());		
	}	

}
