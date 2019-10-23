package com.pool;

import com.pool.task.KaCon;
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

    /**
     * 注意在junit 测试中主线程退出子线程也会退出，虚拟机不会等待全部执行完成
     */
    @Test
    public void test5() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        });

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
        System.out.println("哈哈");
    }


    public static void main(String[] args) {
        //xx();
        yy();
    }

    private static void yy() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        });

        executorService.shutdown();
       /* while (true){
            if (executorService.isTerminated()){
                break;
            }
        }*/
        System.out.println("哈哈");
    }

    private static void xx() {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 999; i++) {
                log.info("{},{}", Thread.currentThread().getName(), i);
            }
        };

        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        System.out.println("哈哈" + Thread.currentThread().getName());
    }
}
