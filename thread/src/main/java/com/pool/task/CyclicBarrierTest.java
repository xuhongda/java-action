package com.pool.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *     CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。当线程到达栅栏位置时将调用await方法，
 *     这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，
 *     而栅栏将被重置以便下次使用。
 * </p>
 * @author xuhongda on 2019/5/16
 * com.pool.task
 * java-action
 */
@Slf4j
public class CyclicBarrierTest {

    private static void t(){

       // CyclicBarrier barrier = new CyclicBarrier(4);
        CyclicBarrier barrier = new CyclicBarrier(4,()->log.info("所有线程都已经到达屏障 to do something..."));
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
            log.info("start r4");
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
