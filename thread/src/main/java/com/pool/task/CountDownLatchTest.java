package com.pool.task;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhongda on 2019/3/26
 * com.pool.task
 * java-action
 */

@Slf4j
public class CountDownLatchTest {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(getTask("A",300L));

        executorService.submit(getTask("B",100L));
        long count = COUNT_DOWN_LATCH.getCount();
        log.info("count = {}",count);
        executorService.shutdown();

        try {
            System.out.println("等待2个子线程执行完毕...");
            COUNT_DOWN_LATCH.await();
           // latch.await(5,TimeUnit.SECONDS);
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Runnable getTask(String str,Long time) {
        return () -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("线程 = {}",Thread.currentThread().getName());
            System.out.println(str);
            COUNT_DOWN_LATCH.countDown();
        };
    }
}
