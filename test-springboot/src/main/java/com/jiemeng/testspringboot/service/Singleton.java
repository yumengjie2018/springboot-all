package com.jiemeng.testspringboot.service;



public enum Singleton {
    INSTANCE;
    public void say(){
        System.out.println("ok");
    }
}
 class Test{
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance==instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        instance.say();

    }
}