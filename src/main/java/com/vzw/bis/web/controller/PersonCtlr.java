package com.vzw.bis.web.controller;


import com.vzw.bis.data.HelloBean;
import com.vzw.bis.data.Person;
import com.vzw.bis.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/person")
public class PersonCtlr {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    private PersonService personService;

    public PersonCtlr(PersonService personService) {
        this.personService = personService;
        System.out.println(getClass().getSimpleName() + ".constructor");
    }

    @RequestMapping(method = GET)
    public List<Person> get() {
        logger.debug("get persons");
        return personService.findAll();
    }

}
