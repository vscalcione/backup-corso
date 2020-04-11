package it.intersistemi.corsojava.segreteriauniversitaria.repository;

import org.springframework.data.repository.CrudRepository;
import it.intersistemi.corsojava.segreteriauniversitaria.entity.Studente;

public interface StudenteRepository extends CrudRepository<Studente, Integer>{
	Iterable<Studente> findByFacoltaIdFacolta(Integer idFacolta);
}
