package com.example.demo.Repository;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);


    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPerson();
    Optional<Person> searchPersonById(UUID id);

    int deletePersonById(UUID id);
    int updatePerson ( UUID id,Person person);
}
