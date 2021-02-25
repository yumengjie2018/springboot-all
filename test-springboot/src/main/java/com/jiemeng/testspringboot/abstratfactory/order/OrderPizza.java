package com.jiemeng.testspringboot.abstratfactory.order;

import com.jiemeng.testspringboot.abstratfactory.Pizza;

public class OrderPizza {
    private AbsFactory absFactory;
    private String orderType;
    public OrderPizza(AbsFactory absFactory,String orderType){
        this.absFactory = absFactory;
        this.orderType=orderType;
        Pizza pizza = absFactory.createPizza(orderType);
        if(pizza!=null){
            pizza.prepare();
            pizza.box();
        }
    }
}
