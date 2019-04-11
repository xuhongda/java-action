package com.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.pool.task.KaCon;
import com.pool.task.Task;
import com.pool.task.TaskExecutor;
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
        if (done) {
            executorService.shutdown();
            log.info("{}", done);

        }
    }

    @Test
    public void testScheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("ScheduledThreadPool"),1L,3L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        log.info("---->>start:"+Thread.currentThread().getName());

        KaCon.t();

        KaCon.method(()-> System.out.println("task one!!!"+Thread.currentThread().getName()));

        TaskExecutor.addTask(() -> {
            while (true){
                log.info("[][][][][]");
            }
        });

        log.info("---->>end:"+Thread.currentThread().getName());
        while (true){}
    }


    @Test
    public void t(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> log.info("i = {}", "xx"));
        }

        executorService.shutdown();

        while (true) {
            boolean terminated = executorService.isTerminated();
            log.info(" {}", terminated);
            if (terminated) {
                break;
            }
        }
    }
}
