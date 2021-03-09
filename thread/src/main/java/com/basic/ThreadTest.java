package com.basic;

import org.junit.Test;
/**
 * @author xuhongda on 2018/11/5
 * com.basic
 * javase-practice
 */
public class ThreadTest {
    @Test
    public void test1() {
        Runtime runtime = Runtime.getRuntime();
        //获得处理器核心数
        int i = runtime.availableProcessors();
        System.out.println(i);

        //以下是java 虚拟机内存情况
        long totalMemory = runtime.totalMemory();
        System.out.println(totalMemory);

        long maxMemory = runtime.maxMemory();
        System.out.println(maxMemory);

        long freeMemory = runtime.freeMemory();
        System.out.println(freeMemory);

    }

    /**
     * join
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        };

        Runnable r2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2");
        };

        Runnable r3 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        //Waits for this thread to die.
        t1.join();
        boolean alive = t1.isAlive();
        System.out.println("t1 alive = "+alive);
        t2.start();
        t2.join();
        t3.start();
    }
}
