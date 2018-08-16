package com.xu.thread.basic;

/**
 * @author xuhongda on 2018/8/16
 * com.xu.thread.basic
 * javase-practice
 */
public class MyThred2 implements Runnable {

    @Override
    public  void run() {

        System.out.println("is runnable "+Thread.currentThread().getName());
    }
}
