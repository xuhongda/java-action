package com.basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class RunnableThread implements Runnable {

    @Override
    public  void run() {
        log.info("start ...");
    }
}
