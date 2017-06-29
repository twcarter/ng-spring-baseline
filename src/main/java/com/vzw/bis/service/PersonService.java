package com.vzw.bis.service;

import com.vzw.bis.data.Person;
import com.vzw.bis.repo.mongodb.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private PersonRepo personRepo;

    @PostConstruct
    public void init() {
        logger.debug(getClass().getSimpleName() + ".init");

        if (personRepo.count()  == 0) {
            logger.debug("PersonRepo is empty, initializing");
            personRepo.save(new Person("Tim", "Carter"));
            personRepo.save(new Person("Mary", "Carter"));
        }

        logger.debug("find by all");
        personRepo.findAll().forEach(System.out::println);

        logger.debug("find by x");
        personRepo.findByX("x").forEach(System.out::println);


    }

    public List<Person> findAll() {
        logger.debug("findAll");
        return personRepo.findAll();
    }
}
