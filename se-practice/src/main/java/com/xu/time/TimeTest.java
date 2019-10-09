package com.xu.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xuhongda on 2019/8/7
 * com.xu.time
 * java-action
 */
@Slf4j
public class TimeTest {


    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 秒转时分秒
     */
    @Test
    public void timeTest001() {
        int s = 8762;
        int N = s / 3600;
        s = s % 3600;
        int K = s / 60;
        s = s % 60;
        int M = s;
        System.out.println("时间是：" + N + "小时 " + K + "分钟 " + M + "秒");
    }


    @Test
    public void test002() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        instance.setTime(new Date());
        instance.add(Calendar.MONTH, 2);
        log.info("time = {}", format.format(instance.getTime()));
    }

    @Test
    public void test003() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        Date time = instance.getTime();
        instance.setTime(new Date());
        instance.add(Calendar.DATE, 2);
        log.info("time = {}", format.format(time));

        int i = 0;
        while (i < 3) {
            log.info("...");
            i += 1;
        }


    }



    /**
     * 时区转换
     */
    @Test
    public void test004() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        Date date = new Date();
        log.info("time = {}",date);

        //java 8 API
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        log.info("time = {}",now);
    }


    @Test
    public void test005(){
        Date date = new Date();
        format.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        String format = this.format.format(date);
        log.info(format);
    }
}
