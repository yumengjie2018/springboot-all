package com.jiemeng.testspringboot.factory.order;

public class OrderStore {

    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza("greek");
        System.out.println("/b");
        OrderPizza cheese = new OrderPizza("cheese");
    }
}
