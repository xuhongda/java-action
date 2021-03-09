package com.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2021/2/24
 * com.basic
 * java-action
 */
public class FixThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        executorService.submit(()-> System.out.println("1"));

        executorService.submit(()-> System.out.println("2"));

        executorService.submit(()-> System.out.println("3"));


        for (int i = 0; i < 5; i++) {
            executorService.submit(()-> System.out.println(5));
        }

        executorService.shutdown();
    }
}
