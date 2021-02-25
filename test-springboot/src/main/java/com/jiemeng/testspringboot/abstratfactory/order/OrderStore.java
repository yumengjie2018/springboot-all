package com.jiemeng.testspringboot.abstratfactory.order;

public class OrderStore {
    public static void main(String[] args) {
        int f1=1,f2=1,f;
        int M=30;
        System.out.println(1);
        System.out.println(2);
        for(int i=3;i<M;i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println(f2);
        }
        new OrderPizza(new BjFactory(),"cheese");
    }
}
