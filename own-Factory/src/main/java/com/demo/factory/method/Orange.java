package com.demo.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Orange implements Fruits {
    private static final Logger logger = LoggerFactory.getLogger(Orange.class);

    @Override
    public void plantFruit() {
        logger.info("种橘子");
        System.out.println("种橘子。");
    }

    @Override
    public void eatFruit() {
        logger.info("吃橘子");
        System.out.println("吃橘子。");
    }
}
