package com.jiemeng.testspringboot.service;

//静态内部类（推荐使用）
public class SingletonTest3 {
    //构造器私有化
    private SingletonTest3(){}

    //写一个静态内部类，改类中有一个静态属性SingletonTest3
    private static class SingletonInstance{
        private final static SingletonTest3 instance=new SingletonTest3();
    }
    //提供一个静态公有方法，直接返回SingletonInstance.instance
    public static synchronized SingletonTest3 getInstance(){
        return SingletonInstance.instance;
    }
}
