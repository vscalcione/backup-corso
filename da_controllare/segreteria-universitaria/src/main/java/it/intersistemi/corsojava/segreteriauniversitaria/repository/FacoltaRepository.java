package it.intersistemi.corsojava.segreteriauniversitaria.repository;

import org.springframework.data.repository.CrudRepository;
import it.intersistemi.corsojava.segreteriauniversitaria.entity.Facolta;

public interface FacoltaRepository extends CrudRepository<Facolta, Integer> {
	Iterable<Facolta> findByStudentesMatricola(Integer matricola);
}
