package it.intersistemi.corso.gestioneAttivita.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corso.gestioneAttivita.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	Iterable<Employee> findByActivitiesIdActivity(String idActivity);
}
