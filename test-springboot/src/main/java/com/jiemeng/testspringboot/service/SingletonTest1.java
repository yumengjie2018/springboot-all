package com.jiemeng.testspringboot.service;
//饿汉式（静态常量）
public class SingletonTest1 {
    //构造器私有化
    private SingletonTest1(){}
    //本类内部创建对象实例
    private final static SingletonTest1 instance=new SingletonTest1();
    //提供一个公有的静态方法，返回实例对象
    public static SingletonTest1 getInstance(){
        return instance;
    }
}
