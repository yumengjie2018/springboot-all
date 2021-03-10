package com.jiemeng.testspringboot.adapter.objectadapter;

//对象适配器模式
public class VoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dstV=0;
        if(voltage220V!=null){
            //通过对象获取220电压
            int srcV=voltage220V.output220V();
            dstV=srcV/44;//转成5V
        }
        return dstV;
    }
}
