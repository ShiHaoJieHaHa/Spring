package com.demo.factory;

import com.demo.factory.abstraction.*;


public class TestAbstractionFactory {
    public static void main(String[] args) {
        Fruits apple=new Apples();
        Meat bigMeat = new BigMeat();
        User me = new User();
        me.getFruits(apple).plantFruit();
        me.getFruits(apple).eatFruit();
        me.getMeat(bigMeat).buyMeat();
        me.getMeat(bigMeat).eatMeat();
    }

    }

