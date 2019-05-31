package com.basic;

import lombok.extern.slf4j.Slf4j;
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
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable r = ()->{
        while (!b){
            log.info(Thread.currentThread().getName()+"do ... something ");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        };
        executorService.submit(r);
        executorService.submit(new Rr());
    }
}
@Slf4j
class Rr implements Runnable{

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName()+"改变b值，打破循环");
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        VolatileTest2.b = true;

    }
}