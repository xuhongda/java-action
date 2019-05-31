package com.xu.num;

import org.junit.Test;

/**
 * @author xuhongda on 2019/5/20
 * com.xu.num
 * java-action
 */
public class MathTest {

    @Test
    public void test(){
        double hypot = Math.hypot(3, 4);
        System.out.println(hypot);
    }

    @Test
    public void test2(){
        double hypot = Math.hypot(Math.hypot(0.2, -0.1), 1);
        System.out.println(hypot);
    }
}
