package com.example.practiceapp.dao;

import com.example.practiceapp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    //recall overloaded methods
    int  insertPerson(UUID id, Person person); //allows us to generate a person with a given id
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    } //allows us to add a person with our own generated id which is a random id

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}

