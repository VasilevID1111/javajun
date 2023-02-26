package com.example.javajun;

import com.example.javajun.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person getPerson(Integer personID) {
        Optional<Person> person = personRepo.findById(personID);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new IllegalArgumentException(); //написать собственные ошибки
        }
    }

    public Iterable<Person> getPersonAll() {
        return personRepo.findAll();
    }

    public String addPerson(Person person) {
        personRepo.save(person);
        if (person.getPersonId() == 0) {
            throw new IllegalArgumentException();
        }
        return "Успешно добавлен person с именем: " + person.getFio();
    }

    public String deletePerson(Integer personID) {
        personRepo.deleteById(personID);
        if (personRepo.existsById(personID)) {
            throw new IllegalArgumentException();
        }
        return "person c именем c personID" + personID + " удален";
    }
}
