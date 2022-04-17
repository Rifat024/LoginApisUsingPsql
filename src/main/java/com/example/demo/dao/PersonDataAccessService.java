package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {

        try {
            String sql = "INSERT INTO person (id,name,password) VALUES (?,?,?)";
            jdbcTemplate.queryForObject(sql, new Object[]{id, person.getName(), person.getPassword()}, (ResultSet, i) -> {
                UUID personId = UUID.fromString(ResultSet.getString("id"));
                String name = ResultSet.getString("name");
                String password = ResultSet.getString("password");
                return new Person(personId, name, password);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Person> selectAllPerson() {
        String sql = "Select id, name ,password from person";
        List<Person> personList = jdbcTemplate.query(sql, (ResultSet, i) -> {
            UUID id = UUID.fromString(ResultSet.getString("id"));
            String name = ResultSet.getString("name");
            String password = ResultSet.getString("password");
            return new Person(id, name, password);
        });
        return personList;
    }

    @Override
    public Optional<Person> searchPersonById(UUID id) {
        try {
            String sql = "Select id, name ,password from person where id=?";
            Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (ResultSet, i) -> {
                UUID personId = UUID.fromString(ResultSet.getString("id"));
                String name = ResultSet.getString("name");
                String password = ResultSet.getString("password");
                return new Person(personId, name, password);
            });
            return Optional.ofNullable(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    @Override
    public int deletePersonById(UUID id) {
        try {
            Optional<Person> personExist = searchPersonById(id);
            if (personExist.isEmpty()) {
                return 0;
            } else {
                String sql = "DELETE from person where id=?";
                jdbcTemplate.queryForObject(sql, new Object[]{id}, (ResultSet, i) -> {
                    UUID personId = UUID.fromString(ResultSet.getString("id"));
                    String name = ResultSet.getString("name");
                    String password = ResultSet.getString("password");
                    return new Person(personId, name, password);
                });
                return 1;
            }
        } catch (EmptyResultDataAccessException empty) {
            empty.printStackTrace();
            System.out.println("The person Does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        try {
            Optional<Person> personExist = searchPersonById(id);
            if (personExist.isEmpty()) {
                return 0;
            } else {
                String sql = "UPDATE person SET id=? ,name=? ,password=? where id=?";
                jdbcTemplate.queryForObject(sql, new Object[]{id, person.getName(), person.getPassword(),id}, (ResultSet, i) -> {
                    UUID personId = UUID.fromString(ResultSet.getString("id"));
                    String name = ResultSet.getString("name");
                    String password = ResultSet.getString("password");
                    return new Person(personId, name, password);
                });
            }

        } catch (EmptyResultDataAccessException empty) {
            empty.printStackTrace();
            System.out.println("Person does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}