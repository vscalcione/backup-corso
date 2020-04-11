package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.ProductReviewRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.Product;
import it.intersistemi.corsojava.amazon.jpadao.model.ProductReview;
import it.intersistemi.corsojava.amazon.jpadao.model.ProductReviewPK;
import it.intersistemi.corsojava.amazon.jpadao.model.User;

@Transactional
@Repository
public class ProductReviewRepositoryJpaImpl extends AbstractCrudRepository<ProductReview, ProductReviewPK> implements ProductReviewRepository {

	public ProductReviewRepositoryJpaImpl() {
		super(ProductReview.class);		
	}
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Iterable<ProductReview> findByUsername(String username) {
		User utente = em.find(User.class, username);
		return em.createQuery("from RecensioneProdotto r where r.utente = :utente", ProductReview.class)
					.setParameter("utente", utente)
					.getResultList();
	}

	@Override
	public Iterable<ProductReview> findByAsinAndPunteggio(String asin, int punteggio) {
		Product prodotto = em.find(Product.class, asin);
		return em.createQuery("from RecensioneProdotto r where r.prodotto = :prodotto and r.punteggio = :punteggio",
				ProductReview.class)
			.setParameter("prodotto", prodotto)
			.setParameter("punteggio", punteggio)
			.getResultList();
			
			
	}

	@Override
	protected ProductReviewPK getPkValue(ProductReview obj) {
		return obj.getId();
	}

	@Override
	protected void executeUpdate(ProductReview current, ProductReview obj) {
		current.setId(obj.getId());
		current.setProdotto(obj.getProdotto());
		current.setPunteggio(obj.getPunteggio());
		current.setTesto(obj.getTesto());
		current.setTitolo(obj.getTitolo());
		current.setUtente(obj.getUtente());		
	}

	
}
