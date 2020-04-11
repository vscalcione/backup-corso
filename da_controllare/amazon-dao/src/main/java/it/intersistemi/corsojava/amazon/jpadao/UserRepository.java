package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	User findByMail(String mail);
}

