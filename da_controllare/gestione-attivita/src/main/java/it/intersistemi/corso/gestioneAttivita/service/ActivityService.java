package it.intersistemi.corso.gestioneAttivita.service;

import it.intersistemi.corso.gestioneAttivita.model.ActivityDto;

public interface ActivityService extends CrudService<ActivityDto, String> {
	public Iterable<ActivityDto> listEmployeeActivity(Integer matrDipendente);
	public void assignEmployeeActivity(String idActivity, Integer idMatricola);
	public void removeEmployeeActivity(String idActivity, Integer idMatricola);
}
