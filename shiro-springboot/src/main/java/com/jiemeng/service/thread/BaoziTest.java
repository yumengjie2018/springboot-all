package com.jiemeng.service.thread;
//线程之间的通信
public class BaoziTest {
    public static void main(String[] args) {
        //创建包子对象
        Baozi baozi=new Baozi();
        //创建包子铺，开始生产包子
        new BaoziPu(baozi).start();
        //创建吃货，开始吃包子
        new Chihuo(baozi).start();
    }
}
