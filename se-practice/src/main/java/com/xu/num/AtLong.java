package com.xu.num;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xuhongda on 2019/10/17
 * com.xu.num
 * java-action
 */
public class AtLong {

    private static final AtomicLong atomicLong = new AtomicLong(0L);


    public static void main(String[] args) {
        Tx.yy();
        Long m = m();
        System.out.println(m);
    }


    static Long m(){

        synchronized (atomicLong){
            atomicLong.addAndGet(1);
        }
        // atomicLong.addAndGet(1);
        if (atomicLong.get() % 2 == 0){
            System.out.println("!!!"+atomicLong.get());
        }
        return atomicLong.get();
    }
}
