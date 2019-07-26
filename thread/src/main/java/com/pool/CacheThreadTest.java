package com.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/7/26
 * com.pool
 * java-action
 */
@Slf4j
public class CacheThreadTest {

    public static void main(String[] args) {
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //                                      60L, TimeUnit.SECONDS,
        //                                      new SynchronousQueue<Runnable>());
        // 原则上可以创建无限大小的线程池，可能导致oom
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(()-> log.info("what is cacheThread?"));

        executorService.shutdown();

    }

}
