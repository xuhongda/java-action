package com.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author xuhongda on 2019/3/15
 * com.pool
 * java-action
 */
@Slf4j
public class ThreadPoolTest {
    @Test
    public void testCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> System.out.println("thread pool"));
        boolean done = future.isDone();
        log.info("{}",done);
        executorService.shutdown();
    }

    @Test
    public void testScheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("ScheduledThreadPool"),1L,3L, TimeUnit.SECONDS);
    }
}
