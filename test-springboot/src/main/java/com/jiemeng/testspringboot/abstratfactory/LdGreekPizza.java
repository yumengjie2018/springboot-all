package com.jiemeng.testspringboot.abstratfactory;


public class LdGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("创建希腊披萨");
    }
}
