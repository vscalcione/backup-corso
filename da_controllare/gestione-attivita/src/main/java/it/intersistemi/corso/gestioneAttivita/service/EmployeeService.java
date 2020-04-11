package it.intersistemi.corso.gestioneAttivita.service;

import it.intersistemi.corso.gestioneAttivita.model.EmployeeDto;

public interface EmployeeService extends CrudService<EmployeeDto, Integer> {
	Iterable<EmployeeDto>  listEmployeeActivities(String idActivity);
	
}
