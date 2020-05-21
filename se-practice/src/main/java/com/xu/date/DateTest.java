package com.xu.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xuhongda on 2019/1/20
 * com.xu.date
 * java-action
 */
@Slf4j
public class DateTest {
    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println(format);

    }

    /**
     * 获取上个月的最后一天
     */
    @Test
    public void getBeforeLastMonthDate() {
        for (int i = 1; i <= 12; i++) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            calendar.set(Calendar.MONTH, month - i);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println(i + "月最后一天：" + sf.format(calendar.getTime()));
        }

    }


    @Test
    public void test7(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        System.out.println(new Date());
        instance.add(Calendar.MINUTE,-23);
        System.out.println(instance.getTime());
        String time = "2017-07-31 16:06:15";
        log.info("time = {}",time);
        java.sql.Date date = new java.sql.Date(instance.getTimeInMillis());
        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(date2);
    }


    @Test
    public void test8(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.poll();
        log.info("queue = {}",queue);
        queue.poll();
        log.info("queue = {}",queue);
        log.info("queue.size = {}",queue.size());

    }
}
