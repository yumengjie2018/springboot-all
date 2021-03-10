package com.jiemeng.testspringboot.bridge;

public class Xiaomi implements Brand {
    @Override
    public void open() {
        System.out.println("小米开");
    }

    @Override
    public void close() {
        System.out.println("小米关");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }
}
