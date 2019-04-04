package com.pool.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author xuhongda on 2019/3/26
 * com.pool.task
 * java-action
 */
@Slf4j
public class Tt {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        log.info("---->>start:"+Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        TaskExecutor.addTask(new Task() {
            @Override
            public void execute() throws Exception {
                System.out.println("task");
            }
        });


       /* executorService.submit(
              TaskExecutor.taskToRunnable(new Task() {
                  @Override
                  public void execute() throws Exception {
                      System.out.println("task"+Thread.currentThread().getName());
                  }
              },executorService)
        );

        executorService.submit(getRun());*/

        log.info("---->>end:"+Thread.currentThread().getName());
    }


    private static Runnable getRun(){
        return ()->{
            while (true){
                System.out.println("run"+Thread.currentThread().getName());
            }
        };
    }
}
