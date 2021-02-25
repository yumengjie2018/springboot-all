package com.jiemeng.testspringboot.abstratfactory.order;

import com.jiemeng.testspringboot.abstratfactory.Pizza;
//一个抽象工厂模式的抽象层（接口）
public interface AbsFactory {
    //让下面的子类来具体实现
    public Pizza createPizza(String orderType);
}
