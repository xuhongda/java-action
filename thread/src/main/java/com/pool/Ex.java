package com.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * example
 * @author xuhongda on 2019/7/12
 * com.pool
 * java-action
 */
@Slf4j
public class Ex {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task1());
        executorService.submit(task2());
        executorService.shutdown();
        countDownLatch.await();
        log.info("两件事都做完 start do something");
    }

    /**
     * 一个任务
     * @return run
     */
    private static Runnable task1() {

        return () -> {
            log.info("需要完成的一件事1");
            countDownLatch.countDown();
        };
    }

    /**
     * 一个任务
     * @return run
     */
    private static Runnable task2() {

        return () -> {
            log.info("需要完成的一件事2");
            countDownLatch.countDown();
        };
    }

}

