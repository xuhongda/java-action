package com.xu.collection;

import org.junit.Test;

/**
 * @author xuhongda on 2018/6/17
 * com.xu.collection
 * javase-practice
 */
public class TreeSetTest {
    @Test
    public void testStr(){

        String s1 = "xu";
        String s2 = new String("yan");
        int i = s1.compareTo(s2);
        System.out.println(i);
    }

    /**
     *  比TA 小 ：-1 ；比 TA 大 ： 1
     */
    @Test
    public void test002(){
        int i = Integer.compare(10, 9);
        //output :1
        System.out.println(i);
    }
}
