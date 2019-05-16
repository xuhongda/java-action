package com.pool.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/5/16
 * com.pool.task
 * java-action
 */
@Slf4j
public class CyclicBarrierTest {

    private static void t(){

        CyclicBarrier barrier = new CyclicBarrier(4);
        int numberWaiting = barrier.getNumberWaiting();
        log.info("numberWaiting ={}",numberWaiting);
        int parties = barrier.getParties();
        log.info("parties ={} ",parties);
        Runnable r1 = ()-> {
            log.info("start r1");
            try {
                //可以起一条分割线作用，在这之前，在这之后，当await = 0时，开始执行之下的
                int await = barrier.await();
                log.info("r1 await = {} , info = {}",await,Thread.currentThread()+"r1 do it...");
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("end r1");
        };

        Runnable r2 = ()-> {
            log.info("stat r2");
            try {
                int await = barrier.await();
                log.info("r2 await = {} , info = {}",await,Thread.currentThread()+"r2 do it...");
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("end r2");
        };

        Runnable r3 = ()-> {
           log.info("start r3");
            try {
                int await = barrier.await();
                log.info("r3 await = {} , info = {}",await,Thread.currentThread()+"r3 do it...");
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("end r3");
        };

        Runnable r4 = ()-> {
            log.info("r4 start r4");
            try {
                int await = barrier.await();
                log.info("r4 await ={},info = {}",await,Thread.currentThread()+"r4 do it...");
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("end r4");
        };
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);
        executorService.submit(r4);

        executorService.shutdown();

        while (true){
            boolean terminated = executorService.isTerminated();
            if (terminated){
                log.info("why not is you");
                break;
            }
        }
    }

    public static void main(String[] args) {
        t();
    }
}
