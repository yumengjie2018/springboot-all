package com.jiemeng.service.thread;

//模拟卖票案例，创建三个线程，同时开启对共享票进行出售
public class RunableTicket {

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunanbleImpl runanble = new RunanbleImpl();
        //创建Thread类对象
        Thread thread0 = new Thread(runanble);
        Thread thread1 = new Thread(runanble);
        Thread thread2 = new Thread(runanble);
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
