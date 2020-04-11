package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.ProductOrderRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductOrderRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrder;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrderPK;

public class ProductOrderRepositorySpringJdbcImpl implements ProductOrderRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<ProductOrder> findAll() {
		return jdbcTemplate.query("Select * from ordine_prodotto", new ProductOrderRowMapper());
	}

	@Override
	public ProductOrder findById(ProductOrderPK id) {
		return jdbcTemplate.queryForObject("Select * from ordine_prodotto where numero_ordine = ?"
				+ "and asin = ? and p_iva = ?",
				new ProductOrderRowMapper(),
				id.getNumeroOrdine(),
				id.getAsin(),
				id.getpIva());
	}

	@Override
	public ProductOrderPK insert(ProductOrder obj) {
		jdbcTemplate.update("INSERT INTO ordine_prodotto (numero_ ordine, p_iva, asin,"
				+ "quantita, prezzo_acquisto, sconto, nome_profilo_spedizione )"
				+ " VALUES (?, ?, ?, ?, ?, ?)",
				obj.getId().getNumeroOrdine(),
				obj.getId().getpIva(),
				obj.getId().getAsin(),
				obj.getQuantita(),
				obj.getPrezzoAcquisto(),
				obj.getSconto(),
				obj.getNomeProfiloSpedizione()
				);
		return obj.getId();
	}

	@Override
	public boolean update(ProductOrder obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE ordine_prodotto SET quantita, prezzo_acquisto, sconto,"
				+ "nome_profilo_spedizione"
				+ " WHERE numero_ ordine = ? and p_iva = ? and asin = ?",
				obj.getQuantita(),
				obj.getPrezzoAcquisto(),
				obj.getSconto(),
				obj.getNomeProfiloSpedizione(),
				obj.getId().getNumeroOrdine(),
				obj.getId().getpIva(),
				obj.getId().getAsin()
				);
		return rowsAffected !=0;
	}
}
