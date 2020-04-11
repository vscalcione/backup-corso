package it.intersistemi.corsojava.spring.jdbc.rowmapper.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.mapper.DipendenteRowMapper;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.model.Dipendente;

public class DipendenteDaoImpl implements DipendenteDao{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public Dipendente findById(int employeeId) {
		Dipendente employee = (Dipendente) getJdbcTemplate().queryForObject("SELECT * FROM EMPLOYEE_TABLE WHERE EMPLOYEE_ID=? ", new Object[] { employeeId }, new DipendenteRowMapper());
		return employee;
	}
	public Collection<Dipendente> findAll() {
		List<Dipendente> listEmployees = getJdbcTemplate().query("SELECT * FROM EMPLOYEE_TABLE", new DipendenteRowMapper());
		return listEmployees;
	}
}
