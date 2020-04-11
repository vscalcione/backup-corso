package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.UserRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.User;

@Transactional
@Repository
public class UserRepositoryJpaImpl extends AbstractCrudRepository<User, String> implements UserRepository {

	public UserRepositoryJpaImpl() {
		super(User.class);		
	}

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findByMail(String mail) {
		return em.find(User.class, mail);
	}

	@Override
	protected String getPkValue(User obj) {
		return obj.getUsername();
	}

	@Override
	protected void executeUpdate(User current, User obj) {
		current.setEmail(obj.getEmail());
		current.setIndirizzi(obj.getIndirizzi());
		current.setPassword(obj.getPassword());
		current.setUsername(obj.getUsername());		
	}

	
}
