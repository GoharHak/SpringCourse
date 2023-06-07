package com.example.springcource.repositories;

import com.example.springcource.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer >{
    Optional<Person> findByFullName(String fullName);

}
