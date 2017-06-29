package com.vzw.bis.repo.mongodb;

import com.vzw.bis.data.Person;
import com.vzw.bis.repo.PersonRepoCustom;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Profile("mongodb")
public interface PersonRepo extends MongoRepository<Person, String>, PersonRepoCustom {

    List<Person> findByFirstname(String name);
    List<Person> findByLastname(String name);
    Person       findById(String id);

}
