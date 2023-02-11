package com.example.javajun;

import com.example.javajun.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public String getPersonAll() {
        return null;
    }

    public void addPerson(Person person) {

    }
}
