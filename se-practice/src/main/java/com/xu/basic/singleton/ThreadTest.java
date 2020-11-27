package com.xu.basic.singleton;

/**
 * @author xuhongda on 2018/8/23
 * com.xu.basic.singleton
 * javase-practice
 */
public class ThreadTest {


    private static void fun(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            if (i % 3 == 0) {
                Thread.sleep(10);
            }
            thread.start();
        }
    }




    public static void main(String[] args) throws InterruptedException {
        //验证懒汉单列模式是否线程安全
        Runnable runnable = SingletonLanHan::getInstance;
       // fun(runnable);

        //验证饿汉单列模式是否线程安全
        Runnable runnable2 = SingletonErHan::getInstance;
        fun(runnable2);
    }
}
