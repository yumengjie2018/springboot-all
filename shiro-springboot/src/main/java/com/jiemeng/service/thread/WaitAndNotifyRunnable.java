package com.jiemeng.service.thread;
/**
 * 等待唤醒案例:线程之间的通信
 *  创建一个顾客线程(消费者):告知老板要的包子的种类和数量，调用wait()方法放弃cpu,进入到waiting状态（无限等待）
 *  创建一个老板线程（生产者）:花了5秒做包子，之后调用notify方法，唤醒顾客
 *
 *  注意：
 *      顾客和老板线程必须使用同步代码块包裹，保证等待和唤醒只能有一个在执行
 *      同步使用的锁对象必须保证唯一
 *      只有锁对象才能调用wait和notify()方法
 */



public class WaitAndNotifyRunnable {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj=new Object();
        //创建一个顾客线程（消费者）
        new Thread(){
            @Override
            public void run() {
                //保证等待和唤醒只能有一个执行，需要使用同步技术
                synchronized (obj){
                    System.out.println("告知老板要的包子数量和种类");
                    //调用wait方法，放弃cpu的执行，进入到waiting无限等待状态
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒之后执行的代码
                    System.out.println("包子已经好了 开吃！");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                //花了5秒做包子
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj){
                    System.out.println("老板包子已完成");
                    obj.notify();
                }
            }
        }.start();
    }
}
