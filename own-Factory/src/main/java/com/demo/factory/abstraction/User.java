package com.demo.factory.abstraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//消费接口
public class User implements UserFactory {
    private static final Logger log = LoggerFactory.getLogger(User.class);

    @Override
    public Fruits getFruits(Fruits fruits) {
        log.info("fruits");
        return fruits;
    }

    @Override
    public Meat getMeat(Meat meat) {
        log.info("meat");
        return meat;
    }
}
