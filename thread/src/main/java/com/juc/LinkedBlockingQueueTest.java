package com.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
/**
 * @author xuhongda
 */
@Slf4j
public class LinkedBlockingQueueTest {

    /**
     *  超出容量将抛出异常
     */
    @Test
    public void test()  {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        queue.add("a");
        queue.add("b");
        boolean c = queue.add("c");
        System.out.println(c);
        log.info("queue---->{}",queue);

        String poll1 = queue.poll();
        String poll2 = queue.poll();
        log.info("p1 == {},p2 == {}",poll1,poll2);
    }


    @Test
    public void test2() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("a");
        queue.put("b");
        queue.put("c");

        log.info("put----->>>{}",queue);
        while (!queue.isEmpty()){
            log.info("poll={}", queue.poll());
        }
        //没有元素时返回 null
        log.info("poll={}", queue.poll());
    }


    /**
     * offer 超过容量将无法添加
     */
    @Test
    public void test3()   {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        queue.offer("a");
        queue.offer("b");
        boolean c = queue.offer("c");
        System.out.println(c);
        log.info("put----->>>{}",queue);
    }

    /**
     * take 没有元素发生阻塞
     */
    @Test
    public void test4() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        String take = queue.take();
        log.info("take----->>>{}",take);
    }
}
