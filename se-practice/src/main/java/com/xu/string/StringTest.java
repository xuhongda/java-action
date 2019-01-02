package com.xu.string;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @author xuhongda on 2018/8/31
 * com.xu.string
 * javase-practice
 */
public class StringTest {


    @Test
    public void test001() {
        String s1 = "hello";
        String s2 = "he";
        String s3 = s2 + new String("llo");
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s3);
    }

    @Test
    public void test002() {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String[] arr = new String[10];
        System.out.println(arr[0]);
    }

    @Test
    public void test4() {
        String s1 = "ABC", s2 = "abv";
        int i = s1.compareTo(s2);
        System.out.println(i);
    }
}
