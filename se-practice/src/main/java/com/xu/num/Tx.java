package com.xu.num;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/10/17
 * com.xu.num
 * java-action
 */
class Tx {

    static void yy() {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            executorService.submit(Tx::x);
        }

        executorService.shutdown();
    }


    private static Long x() {
        AtLong.m();
        AtLong.m();
        AtLong.m();
        y();
        return AtLong.m();
    }

    private static void y() {
        AtLong.m();
    }
}
