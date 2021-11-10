package com.demo.factory;

import com.demo.factory.simple.FruitFactory;

public class TestFactory {
    public static void main(String[] args) {
        FruitFactory.getFurit("Orange").plantFruit();
        FruitFactory.getFurit("Apple").eatFruit();
    }
}
