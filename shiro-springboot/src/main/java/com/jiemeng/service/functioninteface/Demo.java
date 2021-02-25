package com.jiemeng.service.functioninteface;

/**
 * 函数式接口的使用：一般可作为方法的参数和返回值类型
 */
public class Demo {
    //定义一个方法，参数使用函数式接口MyFunctionInteface
    public static void show(MyFunctionInteface myFunctionInteface) {
        myFunctionInteface.method();

    }

    public static void main(String[] args) {
        show(new MyFunctionIntefaceImpl());

        show(new MyFunctionInteface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        //简化lambda表达式，只有一句话，省略参数类型，省略{}，省略分号,省略return
        show(()-> System.out.println("使用lambda表达式"));
    }
}
