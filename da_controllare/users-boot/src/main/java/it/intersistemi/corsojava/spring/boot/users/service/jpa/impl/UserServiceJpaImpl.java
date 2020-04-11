package it.intersistemi.corsojava.spring.boot.users.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.spring.boot.jpa.repository.TodoListRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.UserRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Authority;
import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.User;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.AuthorityMapper;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.UserMapper;
import it.intersistemi.corsojava.spring.boot.model.AuthorityDto;
import it.intersistemi.corsojava.spring.boot.model.UserDTO;
import it.intersistemi.corsojava.spring.boot.service.UserService;

@Service
public class UserServiceJpaImpl
		extends AbstractCrudServiceJpaImpl<User, Integer, UserDTO, UserRepository, UserMapper>
		implements UserService {

	@Autowired
	private TodoListRepository authorityRepository;

	@Autowired
	private AuthorityMapper authorityMapper;

	@Autowired
	public UserServiceJpaImpl(UserRepository repository, UserMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected Integer getPK(User e) {
		return e.getUserId();
	}

	@Override
	public UserDTO findByUserName(String userName) {
		User user = repository.findByUserName(userName).orElse(null);
		return mapper.entityToDto(user);
	}

	@Override
	@Transactional
	public void addAuthority(String userName, String authority) {
		User user = super.repository.findByUserName(userName).orElse(null);
		if(user == null) {
			return;
		}
		Authority authorityE = this.authorityRepository.findById(authority).orElse(null);
		if(authorityE == null) {
			return;
		}
		user.getAuthorities().add(authorityE);
		authorityE.getUsers().add(user);
	}

	@Override
	@Transactional
	public void removeAuthority(String userName, String authority) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<AuthorityDto> listAuthorities(String userName) {
		Iterable<AuthorityDto> authoritiesIt = this.authorityMapper.entityToDto(
				this.authorityRepository.findByUsers_UserName(userName));
		if(authoritiesIt != null) {
			List<AuthorityDto> authorities = new ArrayList<>();
			authoritiesIt.forEach(authorities::add);
//			authoritiesIt.forEach(a -> authorities.add(a));
//			authoritiesIt.forEach((AuthorityDto a) -> {authorities.add(a);});
			return authorities;
		}
		return null;
	}
}
