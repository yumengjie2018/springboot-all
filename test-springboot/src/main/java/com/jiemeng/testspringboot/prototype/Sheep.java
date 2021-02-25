package com.jiemeng.testspringboot.prototype;
//原型模式，克隆  实现Cloneable
public class Sheep implements Cloneable{

    private String name;

    private int age;

    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    //克隆该实例，使用默认的clone方法来完成
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;

        try {
            sheep=(Sheep)super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
