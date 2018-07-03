package com.xu.pdf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuhongda 2018/6/28
 * com.xu.pdf
 * javase-practice
 */
public class Test {
    @org.junit.Test
    public void test(){
        String phoneString = "哈哈,13888889999 3333";
        // 提取数字
        // 1
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(phoneString);
        String all = matcher.replaceAll("@");
        System.out.println("phone:" + all);
        // 2
        Pattern.compile("[^0-9]").matcher(phoneString).replaceAll("");
    }
    @org.junit.Test
    public void test2(){
        Map map = new HashMap();
        map.put("1","xxx");
        map.put("2","dd");
        map.put("3","ff");
        System.out.println(map);
    }
    @org.junit.Test
    public void test3(){
        String str = "信用卡  \n";
        System.out.println(str.length());
    }

    @org.junit.Test
    public void test003(){
        String s = "'sds gdasda" + "\n" + "edaeafd'";
        System.out.println("转换前："+s);
        s = s.replaceAll("\r|\n", "");
        System.out.println("转换后："+s);

    }
}
