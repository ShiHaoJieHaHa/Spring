package com.own.service.impl;

import com.own.pojo.Person;
import com.own.repository.PersonRepository;
import com.own.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonRepository personRepository;

    @Override
    @Cacheable(cacheNames = "PersonServiceImplSave", keyGenerator = "keyGenerator")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        logger.info("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @Cacheable(cacheNames = "PersonServiceImplgetPerson",keyGenerator = "keyGenerator")
    public Person getPersonInfor(Long id) {
        Person p = personRepository.findOne(id);
        logger.info("为id、key为:" + p.getId() + "数据做了缓存");
        logger.info("调用getPersonInfor方法");
        return p;
    }
}
