package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.SellerReviewRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.Seller;
import it.intersistemi.corsojava.amazon.jpadao.model.SellerReview;
import it.intersistemi.corsojava.amazon.jpadao.model.SellerReviewPK;
import it.intersistemi.corsojava.amazon.jpadao.model.User;

@Transactional
@Repository
public class SellerReviewRepositoryJpaImpl extends AbstractCrudRepository<SellerReview, SellerReviewPK> implements SellerReviewRepository {

	public SellerReviewRepositoryJpaImpl() {
		super(SellerReview.class);		
	}

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Iterable<SellerReview> findByUsername(String username) {
		User utente = em.find(User.class, username);
		return em.createQuery("from RecensioneVenditore r where r.utente = :utente",
				SellerReview.class)
				.setParameter("utente", utente)
				.getResultList();
	}

	@Override
	public Iterable<SellerReview> findByPIva(String pIva) {
		Seller venditore = em.find(Seller.class, pIva);
		return em.createQuery("from RecensioneVenditore r where r.venditore = :venditore",
				SellerReview.class)
				.setParameter("venditore", venditore)
				.getResultList();
	}

	@Override
	public Iterable<SellerReview> findByPIvaAndPunteggio(String pIva, int punteggio) {
		Seller venditore = em.find(Seller.class, pIva);
		return em.createQuery("from RecensioneProdotto r where r.venditore = :venditore and r.punteggio = :punteggio",
				SellerReview.class)
			.setParameter("venditore", venditore)
			.setParameter("punteggio", punteggio)
			.getResultList();
	}

	@Override
	protected SellerReviewPK getPkValue(SellerReview obj) {
		return obj.getId();
	}

	@Override
	protected void executeUpdate(SellerReview current, SellerReview obj) {
		current.setId(obj.getId());
		current.setPunteggio(obj.getPunteggio());
		current.setTesto(obj.getTesto());
		current.setTitolo(obj.getTitolo());
		current.setUtente(obj.getUtente());
		current.setVenditore(obj.getVenditore());
	}


		
}
