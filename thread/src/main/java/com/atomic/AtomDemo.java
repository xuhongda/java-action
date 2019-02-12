package com.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 线程原子性问题
 * 导致的是最终值的问题(注意是最终值)
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * com.atomic
 * javase-practice
 **/
@Slf4j
public class AtomDemo {

    private static final long THREAD_NUM = 1800L;

    public static void main(String[] args) {
        open1();
        open2();
    }

    private static void open1() {
        RunnableThread thread = new RunnableThread();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(thread).start();
        }
    }

    private static void open2() {
        AtomicT thread = new AtomicT();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(thread).start();
        }
    }
}

@Slf4j
class RunnableThread implements Runnable {
    private int num;
    @Override
    public void run() {
        try {
            Thread.sleep(Math.round(Math.random() * 10));
            num++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "\t" + num);
    }
}

@Slf4j
class AtomicT implements Runnable {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(Math.round(Math.random() * 100));
            //原子自增
            atomicInteger.getAndIncrement();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "\tatomic\t" + atomicInteger);
    }
}
