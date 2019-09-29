package com.basic;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 内存可见性问题demo,感觉这个demo 展示的并不是内存可见性问题：当开启一个线程更改值，别的线程未感知，是因为线程
 * 执行顺序问题，而非所谓的内存可见性问题。这个demo 展现的问题在于，多线程编程时，由于cpu线程间的切换，程序执行顺序
 * 并未按单线程那样按顺序执行
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class VolatileTest {


    private static boolean b = false;

    static boolean b() {
        b = true;
        return b;
    }

    public static void main(String[] args)  {
        log.info(Thread.currentThread().getName());
        MyRunnable thread = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(thread);
        executorService.shutdown();
        while (true){
            if (executorService.isTerminated()){
                while (b) {
                    log.info(" is end ! ");
                }
                break;
            }
        }
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
        boolean b = VolatileTest.b();
        log.info("{}:线程已经更改boolean 值 ,b = {}",Thread.currentThread().getName(),b);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}