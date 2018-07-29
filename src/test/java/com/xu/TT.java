package com.xu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2018/7/27
 * PACKAGE_NAME
 * javase-practice
 */
public class TT {
    @Test
    public void test(){
        String s = "29.000000000003";
        int i =s.indexOf(".");
        System.out.println(i);
        System.out.println(s.substring(0, i + 3));
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        List list1 = list;
        System.out.println(list == list1);
    }
}
