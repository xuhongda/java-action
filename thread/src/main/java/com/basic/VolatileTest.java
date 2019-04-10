package com.basic;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 内存可见性问题demo,会导致最终值问题
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class VolatileTest {

    private long num = 0L;

    public long increase() {
        num++;
        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable thread = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 600; i++) {
            executorService.submit(thread);
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
    VolatileTest volatileTest = new VolatileTest();

    @Override
    public void run() {
        long increase = volatileTest.increase();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(increase + "\t" + Thread.currentThread().getName());
    }
}