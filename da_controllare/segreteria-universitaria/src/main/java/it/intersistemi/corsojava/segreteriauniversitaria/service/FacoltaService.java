package it.intersistemi.corsojava.segreteriauniversitaria.service;

import it.intersistemi.corsojava.segreteriauniversitaria.model.FacoltaDto;

public interface FacoltaService extends CrudService<FacoltaDto, Integer> {
	public Iterable<FacoltaDto> listStudenteFacolta(Integer matricola);
	public void assignStudenteFacolta(Integer idFacolta, Integer matricola);
	public void removeStudenteFacolta(Integer idFacolta, Integer matricola);
}
