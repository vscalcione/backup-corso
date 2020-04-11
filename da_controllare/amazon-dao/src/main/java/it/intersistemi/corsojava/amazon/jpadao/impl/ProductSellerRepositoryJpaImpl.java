package it.intersistemi.corsojava.amazon.jpadao.impl;

import it.intersistemi.corsojava.amazon.dao.model.SellerProduct;
import it.intersistemi.corsojava.amazon.dao.model.SellerProductPK;
import it.intersistemi.corsojava.amazon.jpadao.SellerProductRepository;

public class ProductSellerRepositoryJpaImpl extends AbstractCrudRepository<SellerProduct, SellerProductPK>implements SellerProductRepository {

	public ProductSellerRepositoryJpaImpl() {
		super(SellerProduct.class);		
	}

	@Override
	protected SellerProductPK getPkValue(SellerProduct obj) {
		return obj.getId();
	}

	@Override
	protected void executeUpdate(SellerProduct current, SellerProduct obj) {
		current.setId(obj.getId());
		current.setPezziDisponibili(obj.getPezziDisponibili());
		current.setPrezzo(obj.getPrezzo());
		current.setProdotto(obj.getProdotto());
		current.setProfiliSpedizioneDisponibili(obj.getProfiliSpedizioneDisponibili());
		current.setVenditore(obj.getVenditore());		
	}


}
