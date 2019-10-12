package com.xu.time;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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


    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        log.info("time = {}", format.format(date));

        //java 8 API
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.info("time = {}", zonedDateTime.format(formatter));
    }


    @Test
    public void test005() {
        Date date = new Date();
        format.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        String format = this.format.format(date);
        log.info(format);
    }


    @Test
    public void test006() {
        // 注意 HH 表示 24 h 制 ， hh 表示 12 小时制
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(new Date());
        log.info(format);
    }


    @Test
    public void test007() throws ParseException {

        String str = "UTC+8";

        String utc = str.replace("UTC", "").trim();
        log.info("utc = {}", utc);
        String s = timeZoneTransfer("2019-10-11 10:30", "yyyy-MM-dd HH:mm", utc, "+3.5");
        log.info(s);


    }


    /**
     * 时区转换
     *
     * @param time           时间字符串
     * @param pattern        格式 "yyyy-MM-dd HH:mm"
     * @param nowTimeZone    eg:+8，0，+9，-1 等等
     * @param targetTimeZone 同nowTimeZone
     * @return
     */
    private static String timeZoneTransfer(String time, String pattern, String nowTimeZone, String targetTimeZone) throws ParseException {
        if (StringUtils.isBlank(time)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + nowTimeZone));
        Date date;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.error("时间转换出错", e);
            return "";
        }
        /*simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + targetTimeZone));
        String format = simpleDateFormat.format(date);*/
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format1.setTimeZone(TimeZone.getTimeZone("GMT" + targetTimeZone));
        String ss = format1.format(date);
        log.info("ss = {}", ss);

        return ss;
    }


    @Test
    public void test008() throws ParseException {
        Timestamp timestamp = Timestamp.valueOf("2019-10-11 23:31:33");
        Long l = timestamp.getTime();
        log.info("l = {}",l);
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = simpleDateFormat.format(date);
        log.info("f ={}",formatTime);

        String str = timeZoneTransfer(formatTime,"+9");
        log.info("str = {}",str);
    }



    private static String timeZoneTransfer(String time, String targetTimeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date date;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.error("时间转换出错", e);
            return "";
        }
        //转换为目标地区 精确到天的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT" + targetTimeZone));
        return format.format(date);
    }
}
