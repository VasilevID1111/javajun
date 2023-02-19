package com.example.javajun;

import com.example.javajun.model.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{personID}")
    public Person getPerson(@PathVariable int personID){
        return personService.getPerson(personID);
    }

    @GetMapping("/all")
    public List<Person> getPersons(){
        return personService.getPersonAll();
    }

    @PostMapping(value = "/add-person", consumes = {"application/json"})
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PostMapping( "/delete/{personID}")
    public String deletePerson(@PathVariable int personID) {
        return personService.deletePerson(personID);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        return "Что-то пошло не так";
    }
}
