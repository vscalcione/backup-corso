package it.intersistemi.corsojava.spring.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Authority;

public interface TodoListRepository extends CrudRepository<Authority, String> {

	Iterable<Authority> findByGroups_GroupName(String groupName);

	Iterable<Authority> findByUsers_UserName(String userName);

}
