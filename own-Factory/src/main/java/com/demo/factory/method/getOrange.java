package com.demo.factory.method;

public class getOrange implements FactoryMethod{
    @Override
    public Fruits getFruit() {
        return new Orange();
    }
}
