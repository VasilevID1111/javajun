package com.example.javajun.person;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public PersonDTO getPerson(Integer personID) {
        Optional<PersonDTO> person = personDAO.findById(personID);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new IllegalArgumentException(); //написать собственные ошибки
        }
    }

    public Iterable<PersonDTO> getPersonAll() {
        return personDAO.findAll();
    }

    @Transactional
    public String addPerson(PersonDTO personDTO) {
        personDAO.save(personDTO);
        if (personDTO.getPersonId() == 0) {
            throw new IllegalArgumentException();
        }
        return "Успешно добавлен person с именем: " + personDTO.getFio();
    }

    @Transactional
    public String deletePerson(Integer personID) {
        personDAO.deleteById(personID);
        if (personDAO.existsById(personID)) {
            throw new IllegalArgumentException();
        }
        return "person c именем c personID" + personID + " удален";
    }
}
