package com.example.javajun.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/persons")
@AllArgsConstructor
@Api(description = "Контроллер для работы с объектом person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    @GetMapping("/{personID}")
    @ApiOperation("Получение объекта person")
    public PersonDTO getPerson(@PathVariable Integer personID){
        return personService.getPerson(personID);
    }

    @GetMapping("/")
    @ApiOperation("Получение всех объектов person")
    public @ResponseBody Iterable<PersonDTO> getPersons(){
        return personService.getPersonAll();
    }

    @PostMapping(name = "/", consumes = {"application/json"})
    @ApiOperation("Добавление объекта person")
    public String addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @DeleteMapping ( "/{personID}")
    @ApiOperation("удаление объекта person")
    public String deletePerson(@PathVariable Integer personID) {
        return personService.deletePerson(personID);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        return "Что-то пошло не так";
    }
}
