package com.demo.factory.abstraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigMeat implements Meat {
    private static final Logger logger = LoggerFactory.getLogger(BigMeat.class);

    @Override
    public void buyMeat() {
        logger.info("买猪肉");
        System.out.println("买猪肉。");
    }

    @Override
    public void eatMeat() {
        logger.info("吃猪肉");
        System.out.println("吃猪肉。");
    }
}
