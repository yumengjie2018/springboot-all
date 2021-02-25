package com.jiemeng.service;
//实现多线程卖票案例
public class RunanbleImpl  implements  Runnable {
    //定义一个多线程的共享票源
    private  static int ticket=100;
    //创建一个锁对象
    Object object=new Object();

    @Override
    public void run() {
        //使用死循环,让卖票操作重复执行
        while (true){
            //同步方法
            payTicketStatic();
//            //同步代码块
//            synchronized (object){
//                //先判断是否存在
//                if (ticket>0){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //票存在，卖票 ticket--
//                    System.out.println(Thread.currentThread().getName()+"-----正在卖第"+ticket+"张票");
//                    ticket--;
//                }
//            }

        }

    }
    //锁方法
    public  void payTicket(){
        synchronized(this) {
            //先判断是否存在
            if (ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在，卖票 ticket--
                System.out.println(Thread.currentThread().getName() + "-----正在卖第" + ticket + "张票");
                ticket--;
            }
        }
    }
    //静态锁方法
    public static  void payTicketStatic(){
        synchronized(RunanbleImpl.class) {
            //先判断是否存在
            if (ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在，卖票 ticket--
                System.out.println(Thread.currentThread().getName() + "-----正在卖第" + ticket + "张票");
                ticket--;
            }
        }
    }
}
