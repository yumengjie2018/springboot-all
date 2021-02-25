package com.jiemeng.service.thread;

public class Chihuo extends Thread{
    private Baozi baozi;

    public Chihuo(Baozi baozi) {
        this.baozi = baozi;
    }
    //设置线程任务

    @Override
    public void run() {
        while (true){
            synchronized (baozi){
                if (baozi.isFlag()==false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒后，吃包子
                System.out.println("吃货正在吃包子");
                baozi.setFlag(false);
                //唤醒包子铺线程，生产包子
                baozi.notify();
                System.out.println("包子吃完了，包子铺继续生产包子");
                System.out.println("-------------------");
            }
        }
    }
}
