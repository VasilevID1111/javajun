package com.example.javajun;

import com.example.javajun.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {
}
