package it.intersistemi.corsojava.segreteriauniversitaria.service.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corsojava.segreteriauniversitaria.entity.Studente;
import it.intersistemi.corsojava.segreteriauniversitaria.model.StudenteDto;

@Component
public class StudenteMapper implements EntityDtoMapper<StudenteDto, Studente>{

	@Override
	public void entityToDto(Studente e, StudenteDto dto) {
		dto.setMatricola(e.getMatricola());
		dto.setNome(e.getNomeStudente());
		dto.setCognome(e.getCognomeStudente());
		dto.setDataNascita(e.getDataNascita());
		dto.setEmail(e.getEmail());
	}

	@Override
	public void dtoToEntity(StudenteDto dto, Studente e) {
		e.setMatricola(dto.getMatricola());
		e.setNomeStudente(dto.getNome());
		e.setCognomeStudente(dto.getCognome());
		e.setDataNascita(dto.getDataNascita());
		e.setEmail(dto.getEmail());
	}

	@Override
	public StudenteDto createDtoInstance() {
		return new StudenteDto();
	}

	@Override
	public Studente createEntityInstance() {
		return new Studente();
	}
}