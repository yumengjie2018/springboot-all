package com.jiemeng.testspringboot.build.improve;

public class Client {

    public static void main(String[] args) {
        CommonHouse commonHouse=new CommonHouse();

        HouseDirector houseDirector=new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();

    }
}
