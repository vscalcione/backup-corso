package it.intersistemi.corsojava.amazon.jpadao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.ShipmentProfileRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.ShipmentProfile;

@Transactional
@Repository
public class ShipmentProfileRepositoryJpaImpl extends AbstractCrudRepository<ShipmentProfile, String> implements ShipmentProfileRepository {

	public ShipmentProfileRepositoryJpaImpl() {
		super(ShipmentProfile.class);		
	}

	@Override
	protected String getPkValue(ShipmentProfile obj) {
		return obj.getNome();
	}

	@Override
	protected void executeUpdate(ShipmentProfile current, ShipmentProfile obj) {
		current.setCosto(obj.getCosto());
		current.setGiorniSpedizione(obj.getGiorniSpedizione());
		current.setNome(obj.getNome());		
	}

	

}
