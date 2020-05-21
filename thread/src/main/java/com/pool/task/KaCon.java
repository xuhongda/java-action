package com.pool.task;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class KaCon {

    public static void t() {
        log.info("---->>start:"+Thread.currentThread().getName());
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),threadFactory);
        Future<?> submit = executor.submit( () -> {
            while (true){
                System.out.println("++++++++++++"+Thread.currentThread().getName());
                Thread.sleep(100L);
            }

        });
        System.out.println(submit.isDone());
    }

    public static void method(TaskOne task) throws Exception {
        TaskExecutor.addTask(()-> {
            System.out.println("task!!!"+Thread.currentThread().getName());
            task.execute();
        });

    }


    public static void main(String[] args) throws Exception {
        method(()-> System.out.println("task one!!!"+Thread.currentThread().getName()));
    }
}
