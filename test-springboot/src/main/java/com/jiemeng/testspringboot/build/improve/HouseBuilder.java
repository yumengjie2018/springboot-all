package com.jiemeng.testspringboot.build.improve;
//抽象的建造者
public abstract class HouseBuilder {

    protected House house=new House();

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();
    //将产品返回
    public House builderHouse(){
        return house;
    }
}
