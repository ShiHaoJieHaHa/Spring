package com.demo.factory;

import com.demo.factory.method.getApple;
import com.demo.factory.method.getOrange;

public class TestFactoryMethod {
    public static void main(String[] args) {
        getApple apple=new getApple();
        apple.getFruit().eatFruit();
        getOrange orange=new getOrange();
        orange.getFruit().eatFruit();
    }
}
