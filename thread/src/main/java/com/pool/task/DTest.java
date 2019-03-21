package com.pool.task;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class DTest {

    public static void main(String[] args) throws InterruptedException {
        TaskExecutor.addTask(new Task() {
            @Override
            public void execute() throws Exception {
                while (true){
                    log.info("execute--->{}", Thread.currentThread().getName());
                    //停止条件
                    if (System.currentTimeMillis()%3==0){
                        return;
                    }
                }
            }
        });

        TaskExecutor.addTask(new Task() {
            @Override
            public void execute() throws Exception {
                log.info("execute--->{}", Thread.currentThread().getName());
            }
        });
        while (true){}
    }
}
