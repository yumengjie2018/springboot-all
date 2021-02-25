package com.jiemeng.service.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//实现多线程卖票案例
public class RunanbleImpl  implements  Runnable {
    //定义一个多线程的共享票源
    private  static int ticket=100;
    //创建一个锁对象
    Lock l=new ReentrantLock();

    @Override
    public void run() {
        //使用死循环,让卖票操作重复执行
        while (true){
            //开启锁
            l.lock();
            //先判断是否存在
            if (ticket>0){
                try {
                    Thread.sleep(100);
                    //票存在，卖票 ticket--
                    System.out.println(Thread.currentThread().getName()+"-----正在卖第"+ticket+"张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放锁 无论是否异常都会释放
                    l.unlock();
                }
            }
        }
    }

}
