package com.demo.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apple implements Fruit {
    private static final Logger logger = LoggerFactory.getLogger(Apple.class);

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
