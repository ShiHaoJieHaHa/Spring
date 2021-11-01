package com.own.service;

import com.own.pojo.Person;

public interface PersonService {
    Person save(Person person);
    Person getPersonInfor(Long id);
}
