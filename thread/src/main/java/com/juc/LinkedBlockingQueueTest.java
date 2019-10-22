package com.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
/**
 * @author xuhongda
 */
@Slf4j
public class LinkedBlockingQueueTest {

    @Test
    public void test()  {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        log.info("add---->{}",queue);

        String poll1 = queue.poll();
        String poll2 = queue.poll();
        log.info("poll1 == {},poll2 == {}",poll1,poll2);
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
    }

    @Test
    public void test3() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        log.info("put----->>>{}",queue);
    }
}
