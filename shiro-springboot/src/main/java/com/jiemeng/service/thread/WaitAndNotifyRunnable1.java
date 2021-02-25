package com.jiemeng.service.thread;

/**
 * 进入到TimeWaiting(计时等待)有两种方式
 * 1、使用sleep(Long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
 * 2、使用wait(Long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程睡醒进入到Runnable/Blocked状态
 *
 * 唤醒的方法:
 *  void notify() 唤醒在此对象监视器上等待的单个线程
 *  void notifyall() 唤醒在此对象监视器上等待的所有线程
 *
 */
public class WaitAndNotifyRunnable1 { public static void main(String[] args) {
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
                    obj.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //唤醒之后执行的代码
                System.out.println("包子已经好了 开吃！");
            }
        }
    }.start();


}

}
