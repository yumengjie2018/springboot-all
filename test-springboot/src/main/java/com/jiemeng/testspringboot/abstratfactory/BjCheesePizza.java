package com.jiemeng.testspringboot.abstratfactory;

public class BjCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建奶酪披萨");
    }
}
