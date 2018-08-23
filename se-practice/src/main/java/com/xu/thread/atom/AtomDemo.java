package com.xu.thread.atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     线程原子性问题
 *
 *     导致的是最终值的问题
 * </p>
 * @author xuhongda on 2018/8/16
 * com.xu.thread.atom
 * javase-practice
 */
public class AtomDemo {

    private static final long THREAD_NUM = 10L;

    public static void main(String[] args) {

            open1();

            open2();
    }

    private static void open1(){
        RunnableThread thread = new RunnableThread();
        for (int i = 0; i <THREAD_NUM ; i++) {
            new Thread(thread).start();
        }
    }

    private static void open2(){
        AtomicT thread = new AtomicT();
        for (int i = 0; i <THREAD_NUM ; i++) {
            new Thread(thread).start();
        }
    }
}

class RunnableThread implements Runnable{
    private int num;
    @Override
    public  void run() {
        try {
             Thread.sleep(Math.round(Math.random()*100));
            num++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       System.out.println(Thread.currentThread().getName()+"\t"+num);
    }
}


class AtomicT implements Runnable{

    protected AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(Math.round(Math.random()*100));
            //原子自增
            atomicInteger.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"\tatomic\t"+atomicInteger);

    }
}
