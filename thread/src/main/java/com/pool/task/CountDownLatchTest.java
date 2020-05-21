package com.pool.task;


import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            log.info("等待2个子线程执行完毕...");
            //如果设定的数量未能全部减少，则不会往下继续执行
            COUNT_DOWN_LATCH.await();
           // latch.await(5,TimeUnit.SECONDS);
            log.info("继续执行主线程");
        } catch (Exception e) {
            log.info("exception",e);
        }
    }

    private static Runnable getTask(String str,Long time) {
        return () -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                log.info("exception",e);
            }
            log.info("str = {}",str);
            //设定的数量减少一
            COUNT_DOWN_LATCH.countDown();
        };
    }
}
