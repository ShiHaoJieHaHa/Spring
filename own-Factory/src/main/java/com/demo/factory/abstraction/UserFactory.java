package com.demo.factory.abstraction;
//消费接口
public interface UserFactory {
     Fruits getFruits(Fruits whichFruit);

     Meat getMeat(Meat meat);

}
