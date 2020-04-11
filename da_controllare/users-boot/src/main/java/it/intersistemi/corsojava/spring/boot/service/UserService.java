package it.intersistemi.corsojava.spring.boot.service;

import java.util.List;

import it.intersistemi.corsojava.spring.boot.model.AuthorityDto;
import it.intersistemi.corsojava.spring.boot.model.UserDTO;


public interface UserService extends CrudService<UserDTO, Integer> {

	UserDTO findByUserName(String userName);

	void addAuthority(String userName, String authority);

	void removeAuthority(String userName, String authority);

	List<AuthorityDto> listAuthorities(String userName);

}
