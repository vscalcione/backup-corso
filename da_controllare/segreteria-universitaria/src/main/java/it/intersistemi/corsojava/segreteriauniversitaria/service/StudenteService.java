package it.intersistemi.corsojava.segreteriauniversitaria.service;

import it.intersistemi.corsojava.segreteriauniversitaria.model.StudenteDto;

public interface StudenteService extends CrudService<StudenteDto, Integer> {
	Iterable<StudenteDto> listStudenteFacolta(Integer idFacolta);
}
