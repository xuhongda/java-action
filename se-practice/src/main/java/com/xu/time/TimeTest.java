package com.xu.time;

import org.junit.Test;

/**
 * @author xuhongda on 2019/8/7
 * com.xu.time
 * java-action
 */
public class TimeTest {

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
}
