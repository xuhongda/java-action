package com.basic;

/**
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
public class ExtendThread extends Thread {


    @Override
    public void run(){
        Ticket.func1();
        System.out.println("is run "+Thread.currentThread().getName());
    }
}