package it.intersistemi.corsojava.spring.jdbc.rowmapper.dao;

import java.util.Collection;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.model.Dipendente;

public interface DipendenteDao {
	public Dipendente findById(int employeeId);
	public Collection<Dipendente> findAll();
}
