package com.jiemeng.service.functioninteface;

/**
 *
 * 函数式接口：有且只有一个抽象方法的接口，称之为函数式接口
 * 接口中的方法默认是抽象的
 * @FunctionalInterface 检测接口是否是一个函数式接口
 */
@FunctionalInterface
public interface MyFunctionInteface {

    public void method();
}
