package com.jiemeng.testspringboot.abstratfactory.order;


import com.jiemeng.testspringboot.abstratfactory.LdCheesePizza;
import com.jiemeng.testspringboot.abstratfactory.LdGreekPizza;
import com.jiemeng.testspringboot.abstratfactory.Pizza;
//伦敦工厂类
public class LdFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if(orderType.equals("greek")){
            pizza=new LdGreekPizza();
        }else if(orderType.equals("cheese")){
            pizza=new LdCheesePizza();
        }
        pizza.setName("伦敦");
        return pizza;
    }
}
