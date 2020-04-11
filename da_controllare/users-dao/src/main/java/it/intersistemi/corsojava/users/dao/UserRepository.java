package it.intersistemi.corsojava.users.dao;

import java.util.List;

import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	void addAuthority(String userName, String authority);
	void removeAuthority(String userName, String authority);
	List<Authority> listAuthorities(String userName);
}
