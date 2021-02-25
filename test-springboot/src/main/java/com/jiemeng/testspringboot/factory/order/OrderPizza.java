package com.jiemeng.testspringboot.factory.order;

import com.jiemeng.testspringboot.factory.Pizza;

public class OrderPizza {

    private String orderType;

    public OrderPizza(String orderType){
        this.orderType=orderType;
        //new工厂对象获取Pizza实例
        Pizza pizza=new SimpleFactory().createPizza(orderType);
        if(pizza!=null){
            pizza.prepare();
            pizza.box();
        }else {
            System.out.println("订购失败");
        }
    }

}
