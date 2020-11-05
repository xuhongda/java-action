package com.xu.collection;

import lombok.SneakyThrows;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author xuhongda on 2019/7/23
 * com.xu.collection
 * java-action
 */
public class BlockQueue {


    public static void main(String[] args) throws InterruptedException {
        test001();
    }

    private static void test001() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.put(1);
                queue.put(2);
                queue.put(3);
                int count = queue.remainingCapacity();
                System.out.println(count);

            }
        });


        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Integer i = queue.take();
                Integer i2 = queue.take();
                Integer i3 = queue.take();
                System.out.println(i2);
                Boolean b = queue.contains(2);
                System.out.println(b);
            }
        });

        executorService.shutdown();
    }

    @Test
    public void test1() throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        boolean b = queue.offer(1);
       queue.put(1);
        if (b){
            Integer i = queue.poll();
            Integer i2 = queue.take();
            System.out.println(i2);
        }
    }


    @Test
    public void test2() throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        //queue.add(1);
        queue.put(1);
        System.out.println(queue);
    }

    @Test
    public void test3() {

       // 模仿 Integer 的 compare 方法
       Integer i = (1>2) ? 1:((3>2) ? 3:2) ;

       System.out.println(i);

    }
}
