package com.demo.factory.abstraction;

import com.demo.factory.simple.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oranges implements Fruit {
    private static final Logger log = LoggerFactory.getLogger(Oranges.class);

    @Override
    public void plantFruit() {
        log.info("种橘子");
        System.out.println("种橘子");
    }

    @Override
    public void eatFruit() {
        log.info("吃橘子");
        System.out.println("吃橘子");
    }
}
