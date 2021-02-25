package com.jiemeng.service.thread;

public class BaoziPu extends Thread{

    private Baozi baozi;

    public BaoziPu(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        //定义一个变量
        int count=0;
        //让包子铺一直生产包子
        while (true){
        synchronized (baozi){
            //对包子进行状态判断
            if(baozi.isFlag()){
                //包子铺调用wait进入等待状态
                try {
                    baozi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            baozi.setPi("薄皮");
            baozi.setXian("三鲜馅");
            count++;
            System.out.println("包子正在生产");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //包子铺生产好包子，修改包子的状态为true
            baozi.setFlag(true);
            //唤醒吃货线程，让吃货吃包子
            baozi.notify();
            System.out.println("包子已经生产好了");
        }
    }
    }
}
