package com.example.practiceapp.api;

import com.example.practiceapp.model.Person;
import com.example.practiceapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public  void addPerson(@Valid @NotBlank @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonBVyId(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson( id);
    }

    @PutMapping("{id}")
    public void updatePerson(@PathVariable("id") UUID id,  @Valid @NotBlank @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
