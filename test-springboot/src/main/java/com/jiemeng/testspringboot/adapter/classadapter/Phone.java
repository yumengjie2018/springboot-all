package com.jiemeng.testspringboot.adapter.classadapter;

public class Phone {

    public void charging(Voltage5V voltage5V){
        if(voltage5V.output5V()==5){
            System.out.println("电压为5v可以充电");
        }else {
            System.out.println("不能充电");
        }

    }
}
