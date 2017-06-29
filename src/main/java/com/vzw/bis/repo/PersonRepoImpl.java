package com.vzw.bis.repo;

import com.google.common.collect.Lists;
import com.vzw.bis.data.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class PersonRepoImpl implements PersonRepoCustom {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Person> findByX(String x) {
        logger.debug(getClass().getSimpleName() + ".findByX");
        return Lists.newArrayList();
    }
}
