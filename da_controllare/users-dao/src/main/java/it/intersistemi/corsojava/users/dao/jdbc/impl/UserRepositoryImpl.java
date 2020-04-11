package it.intersistemi.corsojava.users.dao.jdbc.impl;

import java.util.List;

import it.intersistemi.corsojava.users.dao.UserRepository;
import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.User;

public class UserRepositoryImpl implements UserRepository {
	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Integer id, User entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletebyId(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAuthority(String userName, String authority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAuthority(String userName, String authority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Authority> listAuthorities(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
