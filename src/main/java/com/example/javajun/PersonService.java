package com.example.javajun;

import com.example.javajun.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private  final PersonRepository personRepository;

    public Person getPerson(int personID) {
        Person person = personRepository.getPersonForId(personID);
        if (person == null) {
            throw new IllegalArgumentException();
        }
        return person;
    }

    public List<Person> getPersonAll() {
        List<Person> people = personRepository.getPersonAll();
        return people;
    }

    public void addPerson(Person person) {

    }
}
