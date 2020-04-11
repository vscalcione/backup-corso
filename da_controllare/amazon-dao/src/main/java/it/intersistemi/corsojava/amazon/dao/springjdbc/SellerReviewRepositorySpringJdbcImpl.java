package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.SellerReviewRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.SellerReviewRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.SellerReview;
import it.intersistemi.corsojava.amazon.dao.model.SellerReviewPK;

public class SellerReviewRepositorySpringJdbcImpl implements SellerReviewRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<SellerReview> findAll() {
		return jdbcTemplate.query("Select * from recensione_venditore", new SellerReviewRowMapper());
	}

	@Override
	public SellerReview findById(SellerReviewPK id) {
		return jdbcTemplate.queryForObject("Select * from recensione_venditore where username =? and p_iva = ?",
				new SellerReviewRowMapper(), id.getUsername(), id.getP_iva());
	}

	@Override
	public SellerReviewPK insert(SellerReview obj) {
		jdbcTemplate.update("INSERT INTO recensione_venditore (username, p_iva, punteggio, titolo, testo)"
				+ " VALUES (?, ?, ?, ?, ?)",
				obj.getId().getUsername(),
				obj.getId().getP_iva(),
				obj.getPunteggio(),
				obj.getTitolo(),
				obj.getRecensione()
				);
		return obj.getId();
	}

	@Override
	public boolean update(SellerReview obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE recensione_venditore SET punteggio = ?, titolo = ?,"
				+ " testo = ? WHERE username =? and p_iva = ?",
				obj.getPunteggio(),
				obj.getTitolo(),
				obj.getRecensione(),
				obj.getId().getUsername(),
				obj.getId().getP_iva()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<SellerReview> findByUsername(String username) {
		return jdbcTemplate.query("Select * from recensione_venditore where username =?",
				new SellerReviewRowMapper(), username);
	}

	@Override
	public Iterable<SellerReview> findByPIva(String pIva) {
		return jdbcTemplate.query("Select * from recensione_venditore where p_iva =?",
				new SellerReviewRowMapper(), pIva);
	}

	@Override
	public Iterable<SellerReview> findByPIvaAndPunteggio(String pIva, int punteggio) {
		return jdbcTemplate.query("Select * from recensione_venditore where p_iva =? and punteggio = ?",
				new SellerReviewRowMapper(), pIva, punteggio);
	}

}
