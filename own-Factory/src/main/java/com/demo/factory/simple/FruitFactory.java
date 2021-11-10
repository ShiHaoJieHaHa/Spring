package com.demo.factory.simple;

public class FruitFactory {
    public static Fruit getFurit(String fruitName) {
        if (fruitName.equalsIgnoreCase("Apple")){
            return  new Apple();
        }else if (fruitName.equalsIgnoreCase("Orange")){
            return  new Orange();
        }else{
            return  null;
        }
    }
}