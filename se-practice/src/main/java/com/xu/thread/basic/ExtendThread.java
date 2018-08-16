package com.xu.thread.basic;

/**
 * @author xuhongda on 2018/8/16
 * com.xu.thread.basic
 * javase-practice
 */
public class ExtendThread extends Thread {


    @Override
    public void run(){
        Ticket.func();
        System.out.println("is run "+Thread.currentThread().getName());
    }
}
