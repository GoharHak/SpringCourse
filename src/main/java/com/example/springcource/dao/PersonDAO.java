package com.example.springcource.dao;

import com.example.springcource.models.Book;
import com.example.springcource.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index(){
//        return jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
//    }
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
//    public void save(Person person){
//        jdbcTemplate.update("Insert into Person ( full_name, year_of_birth) VALUES (?,?)",person.getFullName(), person.getYearOfBirth());
//    }
//
//    public void update(int id, Person updatedPerson){
//        jdbcTemplate.update("Update Person Set full_name =?,year_of_birth =? where id =?",updatedPerson.getFullName(), updatedPerson.getYearOfBirth(),updatedPerson.getId());
//    }
//
//    public void delete(int id){
//        jdbcTemplate.update("Delete from Person where id =?", id);
//    }
//
////    for full_name validation
//    public Optional<Person> getPersonByFullName(String full_name){
//        return jdbcTemplate.query("Select * from Person where full_name=?",new Object[]{full_name}, new BeanPropertyRowMapper<Person>(Person.class)).stream().findAny();
//    }
//
//    //Get books by author
//    public List<Book> getBooksByAuthor(int id){
//        return jdbcTemplate.query("Select * from Book where person_id =?", new Object[]{id}, new BeanPropertyRowMapper<Book>(Book.class));
//    }
}
