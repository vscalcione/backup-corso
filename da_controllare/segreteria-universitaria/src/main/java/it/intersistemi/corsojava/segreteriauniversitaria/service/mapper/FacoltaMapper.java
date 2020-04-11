package it.intersistemi.corsojava.segreteriauniversitaria.service.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corsojava.segreteriauniversitaria.entity.Facolta;
import it.intersistemi.corsojava.segreteriauniversitaria.model.FacoltaDto;

@Component
public class FacoltaMapper implements EntityDtoMapper<FacoltaDto, Facolta> {

	@Override
	public void entityToDto(Facolta e, FacoltaDto dto) {
		e.setIdFacolta(dto.getIdFacolta());
		e.setNomeFacolta(dto.getNomeFacolta());
		e.setNumeroIscritti(dto.getNumeroIscritti());
	}

	@Override
	public void dtoToEntity(FacoltaDto dto, Facolta e) {
		dto.setIdFacolta(e.getIdFacolta());
		dto.setNomeFacolta(e.getNomeFacolta());
		dto.setNumeroIscritti(e.getNumeroIscritti());
	}

	@Override
	public FacoltaDto createDtoInstance() {
		return new FacoltaDto();
	}

	@Override
	public Facolta createEntityInstance() {
		return new Facolta();
	}
}