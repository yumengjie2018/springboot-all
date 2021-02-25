package com.jiemeng;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//内部类实现线程的调用
public class ThreadTest {
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"测试一"+i);
                }
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"测试二"+i);
                }
            }
        }).start();
    }
}
