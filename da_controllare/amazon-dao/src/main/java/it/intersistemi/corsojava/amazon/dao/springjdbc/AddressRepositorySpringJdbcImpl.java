package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.corsojava.amazon.dao.AddressRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.AddressRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Address;

public class AddressRepositorySpringJdbcImpl implements AddressRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<Address> findAll() {
		return jdbcTemplate.query("Select * from indirizzo", new AddressRowMapper());
	}

	@Override
	public Address findById(Integer id) {
		return jdbcTemplate.queryForObject("Select * from indirizzo where id = ?",
				new AddressRowMapper(), id);
	}

	@Override
	public Integer insert(Address obj) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update("INSERT INTO indirizzo "
				+ "(username, nominativo, via, cap, citta, provincia, nazione, NUMERO_TELEFONO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				obj.getUsername(),
				obj.getNominativo(),
				obj.getVia(),
				obj.getCap(),
				obj.getCitta(),
				obj.getProvincia(),
				obj.getNazione(),
				obj.getNumeroTelefono(),
				keyHolder
				);
		return keyHolder.getKey().intValue();
	}

	@Override
	public boolean update(Address obj) {
		int rowsAffected = jdbcTemplate.update( "UPDATE indirizzo SET username = ?, nominativo= ?, via = ?,  cap = ?,  "
				+ "citta = ?,  provincia = ?,  nazione = ?,  numero_telefono = ?"
				+ " WHERE id = ?",
				obj.getUsername(),
				obj.getNominativo(),
				obj.getVia(),
				obj.getCap(),
				obj.getCitta(),
				obj.getProvincia(),
				obj.getNazione(),
				obj.getNumeroTelefono(),
				obj.getId()
				);
		return rowsAffected !=0;
	}

	@Override
	public Iterable<Address> findByUsername(String username) {
		return jdbcTemplate.query("Select * from indirizzo where username = ?",
				new AddressRowMapper(), username);
	}

}
