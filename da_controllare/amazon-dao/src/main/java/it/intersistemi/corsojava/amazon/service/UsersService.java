package it.intersistemi.corsojava.amazon.service;

import it.intersistemi.corsojava.amazon.dao.model.Address;
import it.intersistemi.corsojava.amazon.dao.model.User;

public interface UsersService {
	void addUser (User user);
	void modifyUser (User user);
	void deleteUser (User user);
	Iterable<User> userList();
	User readUser (String username);
	void addAddress (Address address);
	void modifyAddress (Address address);
	void deleteAddress (Address address);
	Iterable<Address> addressList ();
	Iterable<Address> addressList (String username);
	Address readAddress (Integer id);;
}