package it.intersistemi.corsojava.spring.boot.users.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.spring.boot.jpa.repository.GroupRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.TodoListRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.UserRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Authority;
import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Group;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.AuthorityMapper;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.GroupMapper;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.UserMapper;
import it.intersistemi.corsojava.spring.boot.model.AuthorityDto;
import it.intersistemi.corsojava.spring.boot.model.GroupDto;
import it.intersistemi.corsojava.spring.boot.model.UserDTO;
import it.intersistemi.corsojava.spring.boot.service.GroupService;

@Service
public class GroupServiceJpaImpl
		extends AbstractCrudServiceJpaImpl<Group, String, GroupDto, GroupRepository, GroupMapper>
		implements GroupService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoListRepository authorityRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AuthorityMapper authorityMapper;

	@Autowired
	public GroupServiceJpaImpl(GroupRepository repository, GroupMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected String getPK(Group e) {
		return e.getGroupName();
	}

	@Override
	@Transactional
	public void addAuthority(String groupName, String authority) {
		Group group = super.repository.findById(groupName).orElse(null);
		if(group == null) {
			return;
		}
		Authority authorityE = this.authorityRepository.findById(authority).orElse(null);
		if(authorityE == null) {
			return;
		}
		group.getAuthorities().add(authorityE);
		authorityE.getGroups().add(group);
	}

	@Override
	@Transactional
	public void removeAuthority(String groupName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<AuthorityDto> listAuthorities(String groupName) {
		Iterable<AuthorityDto> authoritiesIt = this.authorityMapper.entityToDto(this.authorityRepository.findByGroups_GroupName(groupName));
		if(authoritiesIt != null) {
			List<AuthorityDto> authorities = new ArrayList<>();
			authoritiesIt.forEach(authorities::add);
//			authoritiesIt.forEach(a -> authorities.add(a));
//			authoritiesIt.forEach((AuthorityDto a) -> {authorities.add(a);});
			return authorities;
		}
		return null;
	}

	@Override
	@Transactional
	public void addUser(String groupName, String username) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void removeUser(String groupName, String username) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<UserDTO> listUsers(String groupName) {
		Iterable<UserDTO> usersIt = this.userMapper.entityToDto(this.userRepository.findByGroupsGroupName(groupName));
		if(usersIt != null) {
			List<UserDTO> users = new ArrayList<>();
			usersIt.forEach(users::add);
//			usersIt.forEach(u -> users.add(u));
//			usersIt.forEach((UserDto u) -> {users.add(u);});
			return users;
		}
		return null;
	}

}
