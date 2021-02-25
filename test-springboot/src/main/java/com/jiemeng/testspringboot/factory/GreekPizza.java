package com.jiemeng.testspringboot.factory;


public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建希腊披萨");
    }
}
