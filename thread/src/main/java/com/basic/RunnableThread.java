package com.basic;

/**
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
public class RunnableThread implements Runnable {

    @Override
    public  void run() {
        System.out.println("is runnable "+Thread.currentThread().getName());
    }
}
