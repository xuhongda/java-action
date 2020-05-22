package com.xu.collection;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author xuhongda on 2019/7/23
 * com.xu.collection
 * java-action
 */
public class BlockQueue {


    @Test
    public void test1() throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());
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
