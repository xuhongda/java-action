package com.basic;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 内存可见性问题demo
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class VolatileTest {


    private static boolean b = false;

    public static boolean b() {
        b = true;
        return b;
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable thread = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(thread);
        while (b) {
            log.info("<><><><><><><><>" + Thread.currentThread().getName());
        }
        executorService.shutdown();
    }
}

@Slf4j
@Data
@ToString
class MyRunnable implements Runnable {

    /**
     * volatile 关键字
     * 注意： volatile 不具备互斥性；不保证原子性
     */
    @Override
    public void run() {
        VolatileTest.b();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}