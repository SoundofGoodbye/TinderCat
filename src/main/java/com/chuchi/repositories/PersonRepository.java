package com.chuchi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.chuchi.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {

Page<Person> findAll(Pageable pageable);

}
