package it.intersistemi.corsojava.segreteriauniversitaria.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.segreteriauniversitaria.entity.Facolta;
import it.intersistemi.corsojava.segreteriauniversitaria.entity.Studente;
import it.intersistemi.corsojava.segreteriauniversitaria.model.FacoltaDto;
import it.intersistemi.corsojava.segreteriauniversitaria.repository.FacoltaRepository;
import it.intersistemi.corsojava.segreteriauniversitaria.repository.StudenteRepository;
import it.intersistemi.corsojava.segreteriauniversitaria.service.FacoltaService;
import it.intersistemi.corsojava.segreteriauniversitaria.service.mapper.FacoltaMapper;

@Service
public class FacoltaServiceImpl
	extends AbstractCrudServiceJpaImpl<Facolta, Integer, FacoltaDto, FacoltaRepository, FacoltaMapper>
	implements FacoltaService {

	@Autowired
	private StudenteRepository studenteRepository;

	@Autowired
	protected FacoltaServiceImpl(FacoltaRepository repository, FacoltaMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected Integer getPK(Facolta entity) {
		return entity.getIdFacolta();
	}

	@Transactional
	@Override
	public Iterable<FacoltaDto> listStudenteFacolta(Integer matricola) {
		return super.mapper.entityToDto(super.repository.findByStudentesMatricola(matricola));
	}

	@Transactional
	@Override
	public void assignStudenteFacolta(Integer idFacolta, Integer matricola) {
		Facolta facolta = super.repository.findById(idFacolta).orElse(null);
		if(facolta != null) {
			Studente studente = this.studenteRepository.findById(matricola).orElse(null);
			if(studente != null) {
				facolta.getStudentes().add(studente);
				studente.getFacolta().add(facolta);
			}
		}
	}

	@Transactional
	@Override
	public void removeStudenteFacolta(Integer idFacolta, Integer matricola) {
		Facolta facolta = super.repository.findById(idFacolta).orElse(null);
		if(facolta != null) {
			Studente studente = this.studenteRepository.findById(matricola).orElse(null);
			if(studente != null) {
				facolta.getStudentes().remove(studente);
				studente.getFacolta().remove(facolta);
			}
		}
	}
}