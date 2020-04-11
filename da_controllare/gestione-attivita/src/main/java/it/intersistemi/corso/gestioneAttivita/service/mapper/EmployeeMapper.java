package it.intersistemi.corso.gestioneAttivita.service.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corso.gestioneAttivita.entity.Employee;
import it.intersistemi.corso.gestioneAttivita.model.EmployeeDto;

@Component
public class EmployeeMapper implements EntityDtoMapper<EmployeeDto, Employee> {

	@Override
	public void entityToDto(Employee e, EmployeeDto dto) {
		dto.setIdMatricola(e.getIdMatricola());
		dto.setName(e.getName());
		dto.setSurname(e.getSurname());

	}

	@Override
	public void dtoToEntity(EmployeeDto dto, Employee e) {
		e.setIdMatricola(dto.getIdMatricola());
		e.setName(dto.getName());
		e.setSurname(dto.getSurname());
	}

	@Override
	public EmployeeDto createDtoInstance() {
		return new EmployeeDto();
	}

	@Override
	public Employee createEntityInstance() {
		return new Employee();
	}
}