package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.dao.model.ProductOrder;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrderPK;
import it.intersistemi.corsojava.amazon.jpadao.ProductOrderRepository;

@Transactional
@Repository
public class ProductOrderRepositoryJpaImpl extends AbstractCrudRepository<ProductOrder, ProductOrderPK> implements ProductOrderRepository {

	@PersistenceContext
	private EntityManager em;
	
	public ProductOrderRepositoryJpaImpl() {
		super(ProductOrder.class);
	}

	@Override
	protected ProductOrderPK getPkValue(ProductOrder obj) {
		return obj.getId();
	}

	@Override
	protected void executeUpdate(ProductOrder current, ProductOrder obj) {
		current.setId(obj.getId());
		current.setOrdine(obj.getOrdine());
		current.setPrezzoAcquisto(obj.getPrezzoAcquisto());
		current.setProdotto(obj.getProdotto());
		current.setProdottoVenditore(obj.getProdottoVenditore());
		current.setProfiloSpedizione(obj.getProfiloSpedizione());
		current.setQuantita(obj.getQuantita());
		current.setSconto(obj.getSconto());		
	}

}
