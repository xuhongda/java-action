package com.xu.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
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
    public void  timeTest001(){
        int s=3182;
        int N = s/3600;
        s = s%3600;
        int K = s/60;
        s = s%60;
        int M = s;
        System.out.println("时间是："+N+"小时 "+K+"分钟 "+M+"秒");
    }


    @Test
    public void test002(){
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        instance.setTime(new Date());
        instance.add(Calendar.MONTH,2);
        log.info("time = {}",format.format(instance.getTime()));
    }
}
