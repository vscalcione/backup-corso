package it.intersistemi.corsojava.spring.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import it.intersistemi.corsojava.spring.boot.jpa.repository.entity.Group;

public interface GroupRepository extends CrudRepository<Group, String> {

}
