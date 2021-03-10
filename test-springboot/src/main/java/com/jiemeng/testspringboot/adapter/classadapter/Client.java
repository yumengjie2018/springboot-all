package com.jiemeng.testspringboot.adapter.classadapter;

public class Client {
    public static void main(String[] args) {

        String a = "ab";
        String b = "a" + "b";
        System.out.println(a == b);
        System.out.println("类适配器");
        Phone phone=new Phone();
        phone.charging(new VoltageAdapter());
    }
}
