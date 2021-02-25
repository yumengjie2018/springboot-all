package com.jiemeng.testspringboot.factory;


public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建奶酪披萨");
    }
}
