package it.intersistemi.corsojava.spring.boot.users.service.jpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.intersistemi.corsojava.spring.boot.jpa.repository.TodoListRepository;
import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Authority;
import it.intersistemi.corsojava.spring.boot.jpa.repository.mapper.AuthorityMapper;
import it.intersistemi.corsojava.spring.boot.model.AuthorityDto;
import it.intersistemi.corsojava.spring.boot.service.AuthorityService;

@Service
public class AuthorityServiceJpaImpl
	extends AbstractCrudServiceJpaImpl<Authority, String, AuthorityDto, TodoListRepository, AuthorityMapper>
	implements AuthorityService {

	@Autowired
	public AuthorityServiceJpaImpl(TodoListRepository repository, AuthorityMapper mapper) {
		super(repository, mapper);
	}

	@Override
	protected String getPK(Authority e) {
		return e.getAuthority();
	}

}
