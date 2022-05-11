package com.example.demo.Repository;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mockerDao")
public class PersonDataAccessServiceMocker implements PersonDao{

    public static List<Person> dataBase=new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        dataBase.add(new Person(id,person.getName(),person.getPassword()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return dataBase;
    }

    @Override
    public Optional<Person> searchPersonById(UUID id) {
        return dataBase.stream()
                       .filter(person -> person.getId().equals(id))
                       .findFirst() ;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personExist= searchPersonById(id);
        if (personExist.isEmpty()){
            return 0;
        }else{
            dataBase.remove(personExist.get());
            return 1;
        }

    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return searchPersonById(id)
        .map(person1 -> {
            int indexOfPersonToBeUpdate= dataBase.indexOf(person1);
            if (indexOfPersonToBeUpdate>=0){
                dataBase.set(indexOfPersonToBeUpdate,new Person(id,person.getName(),person.getPassword()));
                return 1;
            }else{
                return 0;
            }
        }).orElse(0);

    }
}
