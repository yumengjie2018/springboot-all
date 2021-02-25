package com.jiemeng.testspringboot.abstratfactory.order;

import com.jiemeng.testspringboot.abstratfactory.BjCheesePizza;
import com.jiemeng.testspringboot.abstratfactory.BjGreekPizza;
import com.jiemeng.testspringboot.abstratfactory.Pizza;
//工厂子类
//工厂主要是为了获取实例对象
public class BjFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if(orderType.equals("greek")){
            pizza=new BjGreekPizza();
        }else if(orderType.equals("cheese")){
            pizza=new BjCheesePizza();
        }
        pizza.setName("北京");
        return pizza;
    }
}
