package com.xu.time;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
        log.info("l = {}", l);
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = simpleDateFormat.format(date);
        log.info("f ={}", formatTime);

        String str = timeZoneTransfer(formatTime, "+9");
        log.info("str = {}", str);
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


    @Test
    public void test009() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        Date parse = simpleDateFormat.parse("2019-10-13 00:00");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String format1 = format.format(parse);
        log.info(format1);
    }

    @Test
    public void test010() throws ParseException {


        fromTargetTimeToBeiJinTime("2019-10-14", +9);

    }

    /**
     *
     * @param date 目标地区的 时间 （yyyy-MM-dd）
     * @param utc 目标地区所属时区
     */
    private void fromTargetTimeToBeiJinTime(String date, Integer utc) throws ParseException {
        log.info("转换前的目标地区的结束时间 = {}", date);
        //转化
        int bt = 24 - (utc - 8);
        log.info("utc = {}", utc);
        Calendar instance = Calendar.getInstance();
        instance.setTime(format.parse(date + " " + "00:00:00"));
        instance.add(Calendar.HOUR, bt);
        Date edTime = instance.getTime();
        String endTime = this.format.format(edTime);


        Date parseEndTime = format.parse(endTime);
        long time = parseEndTime.getTime();
        Date date1 = new Date();
        long now = date1.getTime();
        //如果转换后结束的北京时间大于当前北京时间
        while (time > now) {
            // Calendar instance = Calendar.getInstance();
            instance.setTime(parseEndTime);
            instance.add(Calendar.DATE, -1);
            log.info("转换后北京时间大于当前北京时间 -1 天");
            Date time1 = instance.getTime();
            endTime = format.format(time1);
            log.info("p = {}", endTime);
            time = time1.getTime();
            parseEndTime = time1;
        }

        Date parse = format.parse(endTime);
        Date date2 = DateUtils.addSeconds(parse, -1);
        String reallyEndTime = this.format.format(date2);

        //   Calendar instance = Calendar.getInstance();
        instance.setTime(parseEndTime);
        instance.add(Calendar.DATE, -1);
        Date st = instance.getTime();
        String startTime = this.format.format(st);
        log.info("转化后的北京开始时间 = {}", startTime);
        log.info("转化后的北京结束时间 = {}", endTime);
        log.info("转化后真正的北京结束时间（-1 s） = {}", reallyEndTime);
        Timestamp xx = Timestamp.valueOf(startTime);
        Timestamp rr = Timestamp.valueOf(reallyEndTime);
        System.out.println(xx);
        System.out.println(rr);
    }


    @Test
    public void test013(){
        String s = "07:00";
        String substring = s.substring(0, 2);
        Integer integer = Integer.valueOf(substring);
        int i = integer - 1;
        System.out.println(i);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");

        String format1 = format.format(date);
        System.out.println(format1);


        String targetTimeZoneForUTC = getTargetTimeZoneForUTC(24);
        System.out.println(targetTimeZoneForUTC);
    }


    @Test
    public void test014(){
        String targetTimeZoneForUTC = getTargetTimeZoneForUTC(1);
        System.out.println(targetTimeZoneForUTC);
    }



    public static String getTargetTimeZoneForUTC(int targetHoursOfDay){
        String targetTimeZoneId="";
        Calendar calendar = Calendar.getInstance();//服务器时间
        calendar.setTime(new Date());
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);//服务器时区偏移量
        int timeZone= (zoneOffset/1000/60/60);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int diffZone= (targetHoursOfDay-(hourOfDay-timeZone));
        if (Math.abs(diffZone)==12) targetTimeZoneId=diffZone>0 ?"UTC+"+diffZone:"UTC"+diffZone;
        else if (diffZone>0) targetTimeZoneId=diffZone>12 ?"UTC"+(diffZone-24):"UTC+"+diffZone;
        else targetTimeZoneId=diffZone<-12 ?"UTC+"+(diffZone+24):"UTC"+diffZone;
        return targetTimeZoneId;
    }

}
