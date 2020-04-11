package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.ProductRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Product;

@Repository
public class ProductRepositorySpringJdbcImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Iterable<Product> findAll() {
		return jdbcTemplate.query("Select * from prodotto", new ProductRowMapper());
	}

	@Override
	public Product findById(String id) {
		return jdbcTemplate.queryForObject("Select * from prodotto where asin = ?",
				new ProductRowMapper(), id);
	}

	@Override
	public String insert(Product obj) {
		jdbcTemplate.update("INSERT INTO prodotto (asin, nome, descrizione, marca, modello, categoria)"
									+ " VALUES (?, ?, ?, ?, ?, ?)",
									obj.getAsin(), 
									obj.getNome(),
									obj.getDescrizione(),
									obj.getMarca(),
									obj.getModello(),
									obj.getCategoriaId()
									);
		return obj.getAsin();
									
	}

	@Override
	public boolean update(Product obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE prodotto SET nome = ?, descrizione = ?,"
				+ " marca = ?, modello = ?, categoria = ? WHERE asin = ?",
				obj.getNome(),
				obj.getDescrizione(),
				obj.getMarca(),
				obj.getModello(),
				obj.getCategoriaId(),
				obj.getAsin()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<Product> findByName(String nome) {
		return jdbcTemplate.query( "Select * from prodotto where upper(nome) like ?",
				new ProductRowMapper(), nome.toUpperCase()+"%");
	}

}
