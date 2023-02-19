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
        return personRepository.getPersonForId(personID);
    }

    public List<Person> getPersonAll() {
        return personRepository.getPersonAll();
    }

    public String addPerson(Person person) {
        boolean isAdded = personRepository.savePerson(person);
        if (isAdded == false) {
            throw new IllegalArgumentException();
        }
        return "Успешно добавлен person с именем: " + person.getFio();
    }

    public String deletePerson(int personID) {
        boolean isDeleted = personRepository.deletePerson(personID);
        if (isDeleted == false) {
            throw new IllegalArgumentException();
        }
        return "person c именем c personID" + personID + " удален";
    }
}
