package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {	
	Iterable<Address> findByUsername(String username);
}

