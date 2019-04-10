package com.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class ExtendThread extends Thread {


    @Override
    public void run(){
        Ticket.func1();
        log.info("thread name = {}",Thread.currentThread().getName());
    }
}
