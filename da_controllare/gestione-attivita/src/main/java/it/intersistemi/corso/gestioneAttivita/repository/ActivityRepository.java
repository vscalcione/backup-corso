package it.intersistemi.corso.gestioneAttivita.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.gestioneAttivita.entity.Activity;

public interface ActivityRepository extends CrudRepository<Activity, String> {
	Iterable<Activity> findByEmployeesIdMatricola(Integer idMatricola);
}
