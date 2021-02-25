package com.jiemeng.testspringboot.abstratfactory;

public abstract class Pizza {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void box(){
        System.out.println("包装"+name);
    }
}
