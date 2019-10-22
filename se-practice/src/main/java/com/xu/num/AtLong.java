package com.xu.num;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xuhongda on 2019/10/17
 * com.xu.num
 * java-action
 */
public class AtLong {

    private static final AtomicLong ATOMIC_LONG = new AtomicLong(0L);


    public static void main(String[] args) {
        Tx.yy();
        Long m = m();
        System.out.println(m);
    }


    static Long m(){

        synchronized (ATOMIC_LONG){
            ATOMIC_LONG.addAndGet(1);
        }
        // atomicLong.addAndGet(1);
        if (ATOMIC_LONG.get() % 2 == 0){
            System.out.println("!!!"+ATOMIC_LONG.get());
        }
        return ATOMIC_LONG.get();
    }
}
