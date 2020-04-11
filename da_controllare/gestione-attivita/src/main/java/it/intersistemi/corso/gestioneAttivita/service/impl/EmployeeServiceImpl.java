package it.intersistemi.corso.gestioneAttivita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corso.gestioneAttivita.entity.Employee;
import it.intersistemi.corso.gestioneAttivita.model.EmployeeDto;
import it.intersistemi.corso.gestioneAttivita.repository.EmployeeRepository;
import it.intersistemi.corso.gestioneAttivita.service.EmployeeService;
import it.intersistemi.corso.gestioneAttivita.service.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl
	extends AbstractCrudServiceJpaImpl<Employee, Integer, EmployeeDto, EmployeeRepository, EmployeeMapper>
	implements EmployeeService {

	@Autowired
	protected EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		super(employeeRepository, employeeMapper);
	}

	@Override
	protected Integer getPK(Employee entity) {
		return entity.getIdMatricola();
	}

	@Override
	public Iterable<EmployeeDto> listEmployeeActivities(String idActivity) {
		return mapper.entityToDto(repository.findByActivitiesIdActivity(idActivity));
	}
}