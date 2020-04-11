package it.intersistemi.corsojava.users.dao;

import java.util.List;

import it.intersistemi.corsojava.users.model.Authority;
import it.intersistemi.corsojava.users.model.Group;
import it.intersistemi.corsojava.users.model.User;

public interface GroupRepository extends CrudRepository<Group, String> {
	
	void addAuthority(String groupName, String authority);
	void removeAuthority(String groupName, String authority);
	List<Authority> listAuthorities (String groupName);
	void addUser(String groupName, String username);
	void removeUser(String groupName, String username);
	List<User> listUsers (String groupName);
}
