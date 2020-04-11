package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.UserRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.UserRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.User;

public class UserRepositorySpringJdbcImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<User> findAll() {
		return jdbcTemplate.query("Select * from utente", new UserRowMapper());
	}

	@Override
	public User findById(String id) {
		return jdbcTemplate.queryForObject("Select * from utente where username = ?",
				new UserRowMapper(), id);
	}

	@Override
	public String insert(User obj) {
		jdbcTemplate.update("INSERT INTO utente (username, email, password)"
				+ " VALUES (?, ?, ?)",
				obj.getUsername(),
				obj.getEmail(),
				obj.getPassword()
				);
		return obj.getUsername();
	}

	@Override
	public boolean update(User obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE utente SET email = ?, password = ? "
				+ " WHERE username = ?",
				obj.getEmail(),
				obj.getPassword(),
				obj.getUsername()
				);
		return rowsAffected !=0;
	}

	@Override
	public User findByMail(String mail) {
		return jdbcTemplate.queryForObject("Select * from utente where email = ?",
				new UserRowMapper(), mail);
	}

}
