package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.ShipmentProfileRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ShipperProfileRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ShipmentProfile;

public class ShipmentProfileRepositorySpringJdbcImpl implements ShipmentProfileRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<ShipmentProfile> findAll() {
		return jdbcTemplate.query("Select * from profilo_spedizione", new ShipperProfileRowMapper());
	}

	@Override
	public ShipmentProfile findById(String id) {
		return jdbcTemplate.queryForObject("Select * from profilo_spedizione where nome = ?",
				new ShipperProfileRowMapper(), id);
	}

	@Override
	public String insert(ShipmentProfile obj) {
		jdbcTemplate.update("INSERT INTO profilo_spedizione (nome, costo, giorni_spedizione)"
				+ " VALUES (?, ?, ?)",
				obj.getNome(),
				obj.getCosto(),
				obj.getTempoSpedizione()
				);
		return obj.getNome();
	}

	@Override
	public boolean update(ShipmentProfile obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE profilo_spedizione SET costo = ?, profilo_spedizione = ?,"
				+ " WHERE nome = ?",
				obj.getCosto(),
				obj.getTempoSpedizione(),
				obj.getNome()
				);
		return rowsAffected !=0;
	}

}
