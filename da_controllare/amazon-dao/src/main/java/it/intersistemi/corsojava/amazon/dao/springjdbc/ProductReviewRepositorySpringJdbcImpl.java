package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.ProductReviewRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductReviewRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ProductReview;
import it.intersistemi.corsojava.amazon.dao.model.ProductReviewPK;

public class ProductReviewRepositorySpringJdbcImpl implements ProductReviewRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<ProductReview> findAll() {
		return jdbcTemplate.query("Select * from recensione_prodotto", new ProductReviewRowMapper());
	}

	@Override
	public ProductReview findById(ProductReviewPK id) {
		return jdbcTemplate.queryForObject("Select * from recensione_prodotto where username =? and asin = ?",
				new ProductReviewRowMapper(), id.getUsername(), id.getAsin());
	}

	@Override
	public ProductReviewPK insert(ProductReview obj) {
		jdbcTemplate.update("INSERT INTO recensione_prodotto (username, asin, punteggio, titolo, testo)"
				+ " VALUES (?, ?, ?, ?, ?)",
				obj.getId().getUsername(),
				obj.getId().getAsin(),
				obj.getPunteggio(),
				obj.getTitolo(),
				obj.getRecensione()
				);
		return obj.getId();
	}

	@Override
	public boolean update(ProductReview obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE recensione_prodotto SET punteggio = ?, titolo = ?,"
				+ " testo = ? WHERE username =? and asin = ?",
				obj.getPunteggio(),
				obj.getTitolo(),
				obj.getRecensione(),
				obj.getId().getUsername(),
				obj.getId().getAsin()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<ProductReview> findByUsername(String username) {
		return jdbcTemplate.query("Select * from recensione_prodotto where username =?",
				new ProductReviewRowMapper(), username);
	}

	@Override
	public Iterable<ProductReview> findByAsinAndPunteggio(String asin, int punteggio) {
		return jdbcTemplate.query("Select * from recensione_prodotto where asin =? and punteggio = ?",
				new ProductReviewRowMapper(), asin, punteggio);
	}

}
