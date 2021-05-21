package com.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author xuhongda on 2019/5/24
 * com.pool
 * java-action
 */
@Slf4j
public class ScheduledThreadTest {


    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, threadFactory);

        //fixRate(scheduledThreadPoolExecutor);

        sc(scheduledThreadPoolExecutor);

        //withFixRate(scheduledThreadPoolExecutor);

    }

    /**
     * 延迟执行
     */
    private static void sc(ScheduledThreadPoolExecutor executor) {

        ScheduledFuture<?> scheduledFuture = executor.schedule(() -> log.info("run ."), 3, TimeUnit.SECONDS);
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                boolean done = scheduledFuture.isDone();
                log.info("done = {}", done);
                if (done) {
                    break;
                }
            }
        }
    }

    /**
     * 延迟15秒，周期3秒,与scheduleWithFixedDelay 它无需等待任务完成再执行下一个任务
     */
    private static void fixRate(ScheduledThreadPoolExecutor executor) {

        executor.scheduleAtFixedRate(() -> log.info("run ."), 2, 2, TimeUnit.SECONDS);

    }


    /**
     * 之前任务完成后，延迟3秒再执行
     */
    private static void withFixRate(ScheduledThreadPoolExecutor executor) {

        executor.scheduleWithFixedDelay(getRunnable(), 5, 7, TimeUnit.SECONDS);

    }


    private static Runnable getRunnable() {
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
                log.info("run...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        return r;
    }


}