package com.example.javajun.person;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private final PersonService personService;

    @GetMapping("/{personID}")
    public PersonDTO getPerson(@PathVariable Integer personID){
        return personService.getPerson(personID);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<PersonDTO> getPersons(){
        return personService.getPersonAll();
    }

    @PostMapping(name = "/", consumes = {"application/json"})
    public String addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @DeleteMapping ( "/{personID}")
    public String deletePerson(@PathVariable Integer personID) {
        return personService.deletePerson(personID);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        return "Что-то пошло не так";
    }
}
