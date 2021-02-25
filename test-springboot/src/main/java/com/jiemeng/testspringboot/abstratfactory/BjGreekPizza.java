package com.jiemeng.testspringboot.abstratfactory;

public class BjGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建希腊披萨");
    }
}
