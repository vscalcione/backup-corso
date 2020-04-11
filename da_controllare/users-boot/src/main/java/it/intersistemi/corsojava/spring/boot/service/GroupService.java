package it.intersistemi.corsojava.spring.boot.service;

import java.util.List;

import it.intersistemi.corsojava.spring.boot.model.AuthorityDto;
import it.intersistemi.corsojava.spring.boot.model.GroupDto;
import it.intersistemi.corsojava.spring.boot.model.UserDTO;


public interface GroupService extends CrudService<GroupDto, String> {

	void addAuthority(String groupName, String authority);

	void removeAuthority(String groupName, String authority);

	List<AuthorityDto> listAuthorities(String groupName);

	void addUser(String groupName, String username);

	void removeUser(String groupName, String username);

	List<UserDTO> listUsers(String groupName);

}
