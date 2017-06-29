package com.vzw.bis.repo;

import com.vzw.bis.data.Person;

import java.util.List;

/**
 * Created by tcarter on 6/28/17.
 */
public interface PersonRepoCustom {
    List<Person> findByX(String x);
}
