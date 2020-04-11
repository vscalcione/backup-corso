package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.SellerRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.SellerRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Seller;

public class SellerRepositorySpringJdbcImpl implements SellerRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<Seller> findAll() {
		return jdbcTemplate.query("Select * from venditore", new SellerRowMapper());
	}

	@Override
	public Seller findById(String id) {
		return jdbcTemplate.queryForObject("Select * from venditore where p_iva = ?",
				new SellerRowMapper(), id);
	}

	@Override
	public String insert(Seller obj) {
		jdbcTemplate.update("INSERT INTO venditore (p_iva, nome, nazione)"
				+ " VALUES (?, ?, ?)",
				obj.getpIva(),
				obj.getNome(),
				obj.getNazione()
				);
		return obj.getpIva();
	}

	@Override
	public boolean update(Seller obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE venditore SET nome = ?,nazione = ?,"
				+ " WHERE p_iva = ?",
				obj.getNome(),
				obj.getNazione(),
				obj.getpIva()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<Seller> findByName(String nome) {
		return jdbcTemplate.query("Select * from venditore where nome = ?",
				new SellerRowMapper(), nome);
	}

}
