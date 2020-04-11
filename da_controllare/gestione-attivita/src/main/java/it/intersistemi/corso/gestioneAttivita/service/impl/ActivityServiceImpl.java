package it.intersistemi.corso.gestioneAttivita.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corso.gestioneAttivita.entity.Activity;
import it.intersistemi.corso.gestioneAttivita.entity.Employee;
import it.intersistemi.corso.gestioneAttivita.model.ActivityDto;
import it.intersistemi.corso.gestioneAttivita.repository.ActivityRepository;
import it.intersistemi.corso.gestioneAttivita.repository.EmployeeRepository;
import it.intersistemi.corso.gestioneAttivita.service.ActivityService;
import it.intersistemi.corso.gestioneAttivita.service.mapper.ActivityMapper;

@Service
public class ActivityServiceImpl
	extends AbstractCrudServiceJpaImpl<Activity, String, ActivityDto, ActivityRepository, ActivityMapper>
	implements ActivityService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	protected ActivityServiceImpl(ActivityRepository repository, ActivityMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected String getPK(Activity entity) {
		return entity.getIdActivity();
	}

	@Transactional
	@Override
	public String insert(ActivityDto dto) {
		dto.setIdActivity(UUID.randomUUID().toString());
		return super.insert(dto);
	}

	@Transactional
	@Override
	public Iterable<ActivityDto> listEmployeeActivity(Integer matrDipendente) {
		return super.mapper.entityToDto(super.repository.findByEmployeesIdMatricola(matrDipendente));
	}

	@Transactional
	@Override
	public void assignEmployeeActivity(String idActivity, Integer idMatricola) {
		Activity activity = super.repository.findById(idActivity).orElse(null);
		if(activity != null) {
			Employee employee = this.employeeRepository.findById(idMatricola).orElse(null);
			if(employee != null) {
				activity.getEmployees().add(employee);
				employee.getActivities().add(activity);
			}
		}
	}

	@Transactional
	@Override
	public void removeEmployeeActivity(String idActivity, Integer idMatricola) {
		Activity activity = super.repository.findById(idActivity).orElse(null);
		if(activity != null) {
			Employee employee = this.employeeRepository.findById(idMatricola).orElse(null);
			if(employee != null) {
				activity.getEmployees().remove(employee);
				employee.getActivities().remove(activity);
			}
		}
	}
}