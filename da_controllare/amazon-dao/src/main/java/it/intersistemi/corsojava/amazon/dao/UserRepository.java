package it.intersistemi.corsojava.amazon.dao;

import it.intersistemi.corsojava.amazon.dao.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	User findByMail(String mail);
}
