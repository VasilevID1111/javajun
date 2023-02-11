package com.example.javajun;

import com.example.javajun.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private Person [] person = new Person[10];
    public Person getPersonForId(int personID) {
        person[0] = new Person();
        person[0].setPersonId(1);
        person[0].setTown("Perm");
        person[0].setFio("Vasia");
        person[0].setAlive(true);
        Person savePerson = null;
        for (Person person:person) {
            if (person == null) {continue;}
            if (person.getPersonId() == personID) {
                savePerson = person;
            }
        }
        return savePerson;
    }
}
