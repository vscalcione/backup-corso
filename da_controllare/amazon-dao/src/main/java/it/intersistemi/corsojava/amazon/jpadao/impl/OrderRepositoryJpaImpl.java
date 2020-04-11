package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.OrderRepository;
import it.intersistemi.corsojavajava.amazon.jpadao.model.Ordine;
import it.intersistemi.corsojavajava.ammazzon.dao.model.Utente;

@Transactional
@Repository
public class OrderRepositoryJpaImpl extends AbstractCrudRepository<Order, Integer> implements OrderRepository {

	@PersistenceContext
	private EntityManager em;
	
	public OrderRepositoryJpaImpl() {
		super(Order.class);		
	}

	@Override
	public Iterable<Order> findByUsername(String nome) {
		User utente = em.find(User.class, nome);
		return em.createQuery("from Ordine o where o.utente = :utente", Order.class)
			.setParameter("utente", utente)
			.getResultList();
	}

	@Override
	protected Integer getPkValue(Order obj) {
		return obj.getNumeroOrdine();
	}

	@Override
	protected void executeUpdate(Order current, Order obj) {
		current.setIndirizzo(obj.getIndirizzo());
		current.setModalitaPagamento(obj.getModalitaPagamento());
		current.setNumeroOrdine(obj.getNumeroOrdine());
		current.setProdottiOrdinati(obj.getProdottiOrdinati());
		current.setSconto(obj.getSconto());
		current.setStatoPagamento(obj.getStatoPagamento());
		current.setUtente(obj.getUtente());		
	}

	

}
