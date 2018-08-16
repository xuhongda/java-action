package com.xu.thread.basic;


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

    private  static Long num = 1000L;

    public  static void func(){
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

    /**
     * runnable 方式
     */
    private static void way1(){
        Runnable runnable = () -> func();

        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 继承Thread
     */
    private static void way2(){
        Thread thread4 = new MyThread();
        Thread thread5 = new MyThread();
        Thread thread6 = new MyThread();
        Thread thread7 = new MyThread();

        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

    }

    public static void main(String[] args) {

        Ticket.way1();

        Ticket.way2();
        //可用的核心数量
        int i = Runtime.getRuntime().availableProcessors();
        System.err.println(i);

    }
}
