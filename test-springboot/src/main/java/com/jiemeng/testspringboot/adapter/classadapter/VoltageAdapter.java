package com.jiemeng.testspringboot.adapter.classadapter;
//类适配器模式
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        //获取220电压
        int srcV=output220V();
        int dstV=srcV/44;//转成5V
        return dstV;
    }
}
