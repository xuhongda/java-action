package com.basic;


import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 模拟卖票问题
 * 不同线程消费单一资源，由于线程的阻塞，休眠，被唤醒等原因 造成多卖，超卖问题
 * </p>
 *
 * @author xuhongda on 2018/8/16
 * com.basic
 * javase-practice
 */
@Slf4j
public class Ticket {

    private static volatile Long num = 1000L;

    private static volatile AtomicInteger atomicInteger = new AtomicInteger(1000);

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private synchronized  static void type1() {
        while (num > 0) {
            try {
                if (num % 3 == 0) {
                    Thread.sleep(30);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            log.info("type1 还有 = {} 票", num);
            checkNum("type1",num.intValue());
        }
    }

    /**
     * 卖票
     */
    private static void type2() throws InterruptedException {

        boolean b = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS);
        if (b) {
            try {
                while (atomicInteger.intValue() > 0) {
                    try {
                        if (atomicInteger.intValue() % 3 == 0) {
                            Thread.sleep(30);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    atomicInteger.decrementAndGet();

                    log.info(" type2 还有 = {} 票", atomicInteger.intValue());

                    checkNum("type2",atomicInteger.intValue());
                }
            } finally {
                reentrantLock.unlock();
            }
        }else {
            System.out.println("lock have been another thread possessed !!!");
        }
    }

    /**
     *  售卖异常票集合
     */
    private static volatile Map<String,Long> map = new HashMap<>();

    private static void checkNum(String name, int intValue) {

        try {
            if (intValue < 0) {
                map.put(name, (long) intValue);
                throw new RuntimeException(name +"\t"+intValue + " 售票异常");
            }
        } catch (Exception e) {
            log.info("exception", e);
        }

    }

    /**
     * runnable 方式
     */
    private static void way1() {

        ExecutorService executorService = Executors.newFixedThreadPool(10,new TicketThreadFactory("solve tickets way1"));

        int thread = 10;

        for (int i = 0; i < thread; i++) {
            executorService.submit(Ticket::type1);
           log.info("------way1-------");
        }

        executorService.shutdown();

    }

    /**
     * 继承Thread
     */
    private static void way2() {

        ExecutorService executorService = Executors.newFixedThreadPool(10,new TicketThreadFactory("solve tickets way2"));
        int thread = 10;


        for (int i = 0; i < thread; i++) {
            executorService.submit(()->{
                try {
                    Ticket.type2();
                    log.info("------way2-------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4,new TicketThreadFactory("all task"));

        executorService.submit(()->{
            while (num>0){
                if (map.size()>0){
                    System.out.println("**********"+map);
                    List<Runnable> runnables = executorService.shutdownNow();
                    runnables.forEach(r-> System.out.println(r.toString()));
                    break;
                }
            }
        });

        executorService.submit(() -> {
            reentrantLock.lock();
            try{
                System.out.println("start sell tickets ");
            }finally {
                reentrantLock.unlock();
            }
        });

        executorService.submit(Ticket::way1);

        executorService.submit(Ticket::way2);

        executorService.shutdown();
        
    }
}

 class TicketThreadFactory implements ThreadFactory{
     /**
      * Constructs a new {@code Thread}.  Implementations may also initialize
      * priority, name, daemon status, {@code ThreadGroup}, etc.
      *
      * @param r a runnable to be executed by new thread instance
      * @return constructed thread, or {@code null} if the request to
      * create a thread is rejected
      */



     private static final AtomicInteger poolNumber = new AtomicInteger(1);
     private final ThreadGroup group;
     private final AtomicInteger threadNumber = new AtomicInteger(1);
     private final String namePrefix;

     public TicketThreadFactory(String name) {
         SecurityManager s = System.getSecurityManager();
         group = (s != null) ? s.getThreadGroup() :
                 Thread.currentThread().getThreadGroup();
         namePrefix = "pool-" +
                 poolNumber.getAndIncrement() +"-"+name+
                 "-thread-";
     }
     @Override
     public Thread newThread(Runnable r) {
         Thread t = new Thread(group, r,
                 namePrefix + threadNumber.getAndIncrement(),
                 0);
         if (t.isDaemon()) {
             t.setDaemon(false);
         }
         if (t.getPriority() != Thread.NORM_PRIORITY) {
             t.setPriority(Thread.NORM_PRIORITY);
         }
         return t;
     }
 }
