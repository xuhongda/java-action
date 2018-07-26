package com.xu.load;

/**
 * 类初始化顺序
 * <p>
 * 基本原则： 先父类后子类；static 优先；构造器最后
 * 1.父类静态代码块；
 * 2.子类静态代码块；
 * 3.父类非静态代码块；
 * 4.父类构造函数；
 * 5.子类非静态代码块；
 * 6.子类构造函数；
 * </p>
 *
 * @author xuhongda on 2018/7/26
 * com.xu.load
 * javase-practice
 */
public class InitTest {
    {
        System.out.println("普通代码块");
    }

    public InitTest() {
        System.out.println("constructor");
    }
}

class A {

    A() {
        System.out.println("A");
    }

    static {
        System.out.println("A+Static");
    }

    {
        System.out.println("A普通代码块");
    }
}

class B extends A {
    B() {
        System.out.println("B");
    }
}

class C extends B {
    static {
        System.out.println("C+Static");
    }

    C() {
        System.out.println("C");
    }

    {
        System.out.println("C 普通代码块");
    }

    public static void main(String[] args) {
        new InitTest();
        new C();
    }
}