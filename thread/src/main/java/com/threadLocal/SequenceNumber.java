package com.threadLocal;

import lombok.extern.slf4j.Slf4j;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     ThreadLocal 每个线程独自拥有一个变量
 * </p>
 * @author xuhongda on 2019/1/7
 * com.threadLocal
 * java-action
 */
@Slf4j
public class SequenceNumber {


    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal  = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));

    private int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {

        dateFormatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        SimpleDateFormat dateFormat = dateFormatThreadLocal.get();
        String format = dateFormat.format(new Date());
        log.info("time = {}",format);


        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    @Slf4j
    private static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                log.info("thread = {},sn = {}", Thread.currentThread().getName(), sn.getNextNum());
            }
        }
    }

}

