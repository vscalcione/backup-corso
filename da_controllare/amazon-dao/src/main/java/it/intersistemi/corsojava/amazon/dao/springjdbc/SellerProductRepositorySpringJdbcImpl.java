package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.mapper.SellerProductRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.SellerProduct;
import it.intersistemi.corsojava.amazon.dao.model.SellerProductPK;
import it.intersistemi.corsojava.amazon.jpadao.SellerProductRepository;

public class SellerProductRepositorySpringJdbcImpl implements SellerProductRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<SellerProduct> findAll() {
		return jdbcTemplate.query("Select * from prodotto_venditore", new SellerProductRowMapper());
	}

	@Override
	public SellerProduct findById(SellerProductPK id) {
		return jdbcTemplate.queryForObject("Select * from prodotto where p_iva =? and asin = ?",
				new SellerProductRowMapper(), id.getpIva(), id.getAsin());
	}

	@Override
	public SellerProductPK insert(SellerProduct obj) {
		jdbcTemplate.update("INSERT INTO prodotto_venditore (p_iva, asin, prezzo, pezzi_disponibili)"
				+ " VALUES (?, ?, ?, ?)",
				obj.getId().getpIva(),
				obj.getId().getAsin(),
				obj.getPrezzo(),
				obj.getPezziDisponibili()
				);
		return obj.getId();
	}

	@Override
	public boolean update(SellerProduct obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE prodotto_venditore SET prezzo = ?, pezzi_disponibili = ?,"
				+ " WHERE p_iva =? and asin = ?",
				obj.getPrezzo(),
				obj.getPezziDisponibili(),
				obj.getId().getpIva(),
				obj.getId().getAsin()
				);
		return rowsAffected !=0;
	}

	@Override
	public boolean delete(SellerProduct obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(SellerProductPK id) {
		// TODO Auto-generated method stub
		return false;
	}

}
