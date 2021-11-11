package com.demo.factory.abstraction;

import com.demo.factory.simple.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apples implements Fruits {
    private static final Logger logger = LoggerFactory.getLogger(Apples.class);

    @Override
    public void plantFruit() {
        logger.info("种苹果");
        System.out.println("种苹果。");
    }

    @Override
    public void eatFruit() {
        logger.info("吃苹果");
        System.out.println("吃苹果");
    }
}
