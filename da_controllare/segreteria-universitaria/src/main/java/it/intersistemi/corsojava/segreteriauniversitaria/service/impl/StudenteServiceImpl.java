package it.intersistemi.corsojava.segreteriauniversitaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.segreteriauniversitaria.entity.Studente;
import it.intersistemi.corsojava.segreteriauniversitaria.model.StudenteDto;
import it.intersistemi.corsojava.segreteriauniversitaria.repository.StudenteRepository;
import it.intersistemi.corsojava.segreteriauniversitaria.service.StudenteService;
import it.intersistemi.corsojava.segreteriauniversitaria.service.mapper.StudenteMapper;

@Service
public class StudenteServiceImpl
	extends AbstractCrudServiceJpaImpl<Studente, Integer, StudenteDto, StudenteRepository, StudenteMapper>
	implements StudenteService {

	@Autowired
	protected StudenteServiceImpl(StudenteRepository studenteRepository, StudenteMapper studenteMapper) {
		super(studenteRepository, studenteMapper);
	}

	@Override
	protected Integer getPK(Studente entity) {
		return entity.getMatricola();
	}

	@Override
	public Iterable<StudenteDto> listStudenteFacolta(Integer idFacolta) {
		return mapper.entityToDto(repository.findByFacoltaIdFacolta(idFacolta));
	}
}