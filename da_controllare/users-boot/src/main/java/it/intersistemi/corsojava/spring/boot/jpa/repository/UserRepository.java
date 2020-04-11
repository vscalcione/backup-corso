package it.intersistemi.corsojava.spring.boot.jpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserName(String userName);

	Iterable<User> findByGroupsGroupName(String groupName);
}
