package com.example.demo.Controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    public final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        System.out.println(person);
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        System.out.println(personService.getAllPerson());
        return personService.getAllPerson();
    }

    @GetMapping(path = "id={id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "id={id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "id={id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        personService.updatePerson(id, person);
    }


}
