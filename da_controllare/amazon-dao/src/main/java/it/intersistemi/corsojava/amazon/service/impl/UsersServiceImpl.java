package it.intersistemi.corsojava.amazon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.amazon.dao.AddressRepository;
import it.intersistemi.corsojava.amazon.dao.UserRepository;
import it.intersistemi.corsojava.amazon.dao.model.Address;
import it.intersistemi.corsojava.amazon.dao.model.User;
import it.intersistemi.corsojava.amazon.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Address> addressList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Address> addressList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address readAddress(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}