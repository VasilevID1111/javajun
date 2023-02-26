package com.example.javajun.person;

import com.example.javajun.person.PersonDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<PersonDTO, Integer> {
}
