package com.basic;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     模拟卖票问题
 *     不同线程消费单一资源，由于线程的阻塞，休眠，被唤醒等原因 造成多卖，超卖问题
 * </p>
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class Ticket {

    private static Long num = 1000L;

    private static AtomicInteger atomicInteger = new AtomicInteger(1000);

    static ReentrantLock reentrantLock = new ReentrantLock();

    static void func1(){
        while (num>0){
            try {
                if (num%3==0){
                    Thread.sleep(7);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            log.info("还有 = {} 票",num);
            checkNum(num.intValue());
        }
    }

    /**
     *  卖票
     */
    private  static void func2(){

            reentrantLock.lock();
            try {
                while (atomicInteger.intValue()>0){
                    try {
                        if (atomicInteger.intValue()%3==0){
                            Thread.sleep(7);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    atomicInteger.decrementAndGet();

                    log.info("还有 = {} 票",atomicInteger.intValue());

                    checkNum(atomicInteger.intValue());
                }
            }finally {
                reentrantLock.unlock();
            }

        }



    private static void checkNum(int intValue) {

        try {
            if (intValue < 0){
                throw new RuntimeException(intValue + " 售票异常");
            }
        }catch (Exception e){
            log.info("exception",e);
           // e.printStackTrace();
        }

    }

    /**
     * runnable 方式
     */
    private static void way1(){

       // Runnable runnable = () -> func1();

        Runnable runnable2 = Ticket::func2;

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int thread = 10;

        for (int i =0;i<thread;i++){
            executorService.submit(runnable2);
        }

        executorService.shutdown();

    }

    /**
     * 继承Thread
     */
    private static void way2(){

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new ExtendThread());

    }

    public static void main(String[] args) {

        Ticket.way1();

        //Ticket.way2();


    }
}
