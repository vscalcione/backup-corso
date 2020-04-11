package it.intersistemi.corsojava.spring.boot.jpa.repository.mapper;

import org.springframework.stereotype.Component;

import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.User;
import it.intersistemi.corsojava.spring.boot.model.UserDTO;

@Component
public class UserMapper implements EntityDtoMapper<UserDTO, User> {

	@Override
	public void dtoToEntity(UserDTO dto, User e) {
		if(dto.getUserId() != null) {
			e.setUserId(dto.getUserId());
		}
		e.setUserName(dto.getUserName());
		e.setPassword(dto.getPassword());
		e.setEnabled(dto.isEnabled());
	}

	@Override
	public User createEntityInstance() {
		return new User();
	}

	@Override
	public void entityToDto(User e, UserDTO dto) {
		dto.setUserId(e.getUserId());
		dto.setUserName(e.getUserName());
		dto.setPassword(e.getPassword());
		dto.setEnabled(e.getEnabled());
	}

	@Override
	public UserDTO createDtoInstance() {
		return new UserDTO();
	}

}
