package com.jiemeng.testspringboot.bridge;

public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("ViVo开");
    }

    @Override
    public void close() {
        System.out.println("ViVo关");
    }

    @Override
    public void call() {
        System.out.println("ViVo打电话");
    }
}
