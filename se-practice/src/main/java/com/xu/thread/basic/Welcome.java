package com.xu.thread.basic;

/**
 * @author xuhongda on 2018/8/16
 * com.xu.thread.basic
 * javase-practice
 */
public class Welcome {
    public static void main(String[] args) {
        //继承Thread 类
        Thread thread = new MyThread();
        //给线程命名
        thread.setName("线程一");
        thread.start();


        //runnable 方式
        Thread thread1 = new Thread(new MyThred2());
        thread1.start();

        //以lambda 方式创建
        Runnable runnable = () -> System.out.println("lambda\t" + Thread.currentThread().getName());
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
