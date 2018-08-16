package com.xu.thread.atom;

import java.util.Random;
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
    public static void main(String[] args) {
        RunnableThread thread = new RunnableThread();
        for (int i = 0; i <10 ; i++) {
            new Thread(thread).start();
        }

    }


}

class RunnableThread implements Runnable{
    private    int num;
    //protected AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public  void run() {
        try {
             Thread.sleep(Math.round(Math.random()*100));
            num++;
            //原子自增
         // atomicInteger.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       System.out.println(Thread.currentThread().getName()+"\t"+num);
      // System.out.println(Thread.currentThread().getName()+"\tatomic\t"+atomicInteger);
    }
}