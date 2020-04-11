package it.intersistemi.corsojava.spring.boot.jpa.repository.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Group;
import it.intersistemi.corsojava.spring.boot.model.GroupDto;

@Component
public class GroupMapper implements EntityDtoMapper<GroupDto, Group> {

	@Override
	public void dtoToEntity(GroupDto dto, Group e) {
		e.setGroupName(dto.getGroupName());
		e.setDescription(dto.getDescription());
	}

	@Override
	public Group createEntityInstance() {
		return new Group();
	}

	@Override
	public void entityToDto(Group e, GroupDto dto) {
		dto.setGroupName(e.getGroupName());
		dto.setDescription(e.getDescription());
	}

	@Override
	public GroupDto createDtoInstance() {
		return new GroupDto();
	}

}
