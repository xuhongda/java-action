package com.basic;

import org.junit.Test;

/**
 * @author xuhongda on 2018/11/5
 * com.basic
 * javase-practice
 */
public class ThreadTest {
    @Test
    public void test1() {
        Runtime runtime = Runtime.getRuntime();
        //获得处理器核心数
        int i = runtime.availableProcessors();
        System.out.println(i);

        //以下是java 虚拟机内存情况
        long totalMemory = runtime.totalMemory();
        System.out.println(totalMemory);

        long maxMemory = runtime.maxMemory();
        System.out.println(maxMemory);

        long freeMemory = runtime.freeMemory();
        System.out.println(freeMemory);

    }
}
