package com.demo.factory.method;

public class getApple  implements FactoryMethod{
    @Override
    public Fruits getFruit() {
        return new Apple();
    }
}
