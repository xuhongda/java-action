package com.xu.thread.basic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     模拟卖票问题
 *     不同线程消费单一资源，由于线程的阻塞，休眠，被唤醒等原因 造成多卖，超卖问题
 * </p>
 * @author xuhongda on 2018/8/16
 * com.xu.thread.basic
 * javase-practice
 */
public class Ticket {

    private static Long num = 1000L;

    private static AtomicInteger atomicInteger = new AtomicInteger(1000);

    protected static void func1(){
        while (num>0){
            try {
                if (num%3==0){
                    Thread.sleep(7);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            System.out.println("还有\t"+num);
            if (num<0){
                System.err.println(num);
            }
        }
    }


    protected static void func2(){
        while (atomicInteger.intValue()>0){
            try {
                if (atomicInteger.intValue()%3==0){
                    Thread.sleep(7);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.decrementAndGet();
            System.out.println("还有\t"+atomicInteger.intValue());
            if (atomicInteger.intValue()<0){
                System.err.println(atomicInteger.intValue());
            }
        }
    }

    /**
     * runnable 方式
     */
    private static void way1(){

       // Runnable runnable = () -> func1();

        Runnable runnable2 = () -> func2();

        for (int i = 0; i <10 ; i++) {
            new Thread(runnable2).start();
        }
    }

    /**
     * 继承Thread
     */
    private static void way2(){
        Thread thread4 = new ExtendThread();
        Thread thread5 = new ExtendThread();
        Thread thread6 = new ExtendThread();
        Thread thread7 = new ExtendThread();

        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

    }

    public static void main(String[] args) {

        Ticket.way1();

        //Ticket.way2();
        //可用的核心数量
        int i = Runtime.getRuntime().availableProcessors();
        System.err.println(i);

    }
}
