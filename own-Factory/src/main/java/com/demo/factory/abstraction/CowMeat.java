package com.demo.factory.abstraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CowMeat implements Meat {
    private static final Logger logger = LoggerFactory.getLogger(CowMeat.class);

    @Override
    public void buyMeat() {
        logger.info("买牛肉");
        System.out.println("买牛肉。");
    }

    @Override
    public void eatMeat() {
        logger.info("吃牛肉");
        System.out.println("吃牛肉。");
    }
}
