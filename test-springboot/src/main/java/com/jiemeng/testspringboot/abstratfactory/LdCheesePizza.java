package com.jiemeng.testspringboot.abstratfactory;


public class LdCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建奶酪披萨");
    }
}
