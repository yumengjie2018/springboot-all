package com.jiemeng.testspringboot.factory.order;


import com.jiemeng.testspringboot.factory.CheesePizza;
import com.jiemeng.testspringboot.factory.GreekPizza;
import com.jiemeng.testspringboot.factory.Pizza;

//简单工厂模式
public class SimpleFactory {
    //根据对象的type,返回对应的实例
    public Pizza createPizza(String orderType){
        Pizza pizza=null;
        System.out.println("使用简单工厂模式");
        if(orderType.equals("greek")){
            pizza=new GreekPizza();
            pizza.setName("希腊披萨");
        }else if(orderType.equals("cheese")){
            pizza=new CheesePizza();
            pizza.setName("奶酪披萨");
        }
        return pizza;
    }
}
