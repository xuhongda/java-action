package com.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 内存可见性问题，log 可能会一直停止不下来，但是问题并不容易复现
 * @author xuhongda on 2019/5/31
 * com.basic
 * java-action
 */
@Slf4j
public class VolatileTest2 {
    static volatile boolean b =false;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        Runnable r = ()->{
        while (!b){
            log.info("do ... something ");
        }
        };
        executorService.submit(r);
        executorService.submit(new Rr());
    }
}

class Rr implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        VolatileTest2.b = true;

    }
}