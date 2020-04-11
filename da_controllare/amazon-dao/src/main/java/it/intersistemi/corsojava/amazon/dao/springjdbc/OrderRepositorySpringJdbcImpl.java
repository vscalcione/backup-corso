package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.corsojava.amazon.dao.OrderRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.OrderRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Order;

public class OrderRepositorySpringJdbcImpl implements OrderRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<Order> findAll() {
		return jdbcTemplate.query("Select * from ordine", new OrderRowMapper());
	}

	@Override
	public Order findById(Integer id) {
		return jdbcTemplate.queryForObject("Select * from ordine where numero_ordine = ?",
				new OrderRowMapper(), id);
	}

	@Override
	public Integer insert(Order obj) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update("INSERT INTO ordine (stato_pagamento, modalita_pagamento, sconto, username, indirizzo_spedizione)"
				+ " VALUES (?, ?, ?, ?, ?)",
				obj.getStatoPagamento(),
				obj.getModalitaPagamento(),
				obj.getSconto(),
				obj.getUsername(),
				obj.getIndirizzoSpedizione(),
				keyHolder
				);
		return keyHolder.getKey().intValue();
	}

	@Override
	public boolean update(Order obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE ordine SET stato_pagamento =?, modalita_pagamento =?,"
				+ "sconto =?, username =?, indirizzo_spedizione =? WHERE numero_ordine = ?",
				obj.getStatoPagamento(),
				obj.getModalitaPagamento(),
				obj.getSconto(),
				obj.getUsername(),
				obj.getIndirizzoSpedizione(),
				obj.getnOrdine()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<Order> findByUsername(String nome) {
		return jdbcTemplate.query("Select * from ordine where username = ?",
				new OrderRowMapper(), nome);
	}

}
