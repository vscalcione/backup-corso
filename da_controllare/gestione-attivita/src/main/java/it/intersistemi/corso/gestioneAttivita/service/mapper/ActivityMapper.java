package it.intersistemi.corso.gestioneAttivita.service.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corso.gestioneAttivita.entity.Activity;
import it.intersistemi.corso.gestioneAttivita.model.ActivityDto;

@Component
public class ActivityMapper implements EntityDtoMapper<ActivityDto, Activity> {

	@Override
	public void entityToDto(Activity e, ActivityDto dto) {
		dto.setIdActivity(e.getIdActivity());
		dto.setActivityName(e.getActivityName());
		dto.setStartDate(e.getStartDate());
		dto.setEndDate(e.getEndDate());

	}

	@Override
	public void dtoToEntity(ActivityDto dto, Activity e) {
		e.setIdActivity(dto.getIdActivity());
		e.setActivityName(dto.getActivityName());
		e.setStartDate(dto.getStartDate());
		e.setEndDate(dto.getEndDate());
	}

	@Override
	public ActivityDto createDtoInstance() {
		return new ActivityDto();
	}

	@Override
	public Activity createEntityInstance() {
		return new Activity();
	}
}