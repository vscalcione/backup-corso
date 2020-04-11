package it.intersistemi.corsojava.spring.jdbc.rowmapper.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.model.Dipendente;

public class DipendenteRowMapper implements RowMapper{
	public Dipendente mapRow(ResultSet rs, int numRow) throws SQLException{
		Dipendente dipendente = new Dipendente();
		dipendente.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
		dipendente.setEmployeeName(rs.getString("EMPLOYEE_FULLNAME"));
		dipendente.setEmployeeDesignation(rs.getString("EMPLOYEE_DESIGNATION"));
		dipendente.setEmployeeSalary(rs.getFloat("EMPLOYEE_SALARY"));
		return dipendente;
	}
}
