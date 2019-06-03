package com.xu.math;

import org.junit.Test;

/**
 * @author xuhongda on 2019/6/3
 * com.xu.math
 * java-action
 */
public class MathTest {

    @Test
    public void test(){
        //把数字转换为角度
        double v = Math.toRadians(30d);
        //sin
        double asin = Math.sin(v);
        System.out.println(asin);
        //cos
        double cos = Math.cos(v);
        System.out.println(cos);
    }

    /**
     * 反正弦函数
     */
    @Test
    public void test1(){
        double asin = Math.asin(1);
        System.out.println(asin);
    }

    /**
     * 平方根   --->>>2
     */
    @Test
    public void test2(){
        double sqrt = Math.sqrt(4);
        System.out.println(sqrt);
    }

    /**
     * 2 的 2 次方
     */
    @Test
    public void test3(){
        double pow = Math.pow(2,2);
        System.out.println(pow);
    }

    /**
     *  绝对值
     */
    @Test
    public void test4(){
        double abs = Math.abs(-9);
        System.out.println(abs);
    }

    /**
     *  返回最大值/最小值
     */
    @Test
    public void test5(){
        double ceil = Math.ceil(2.2);
        System.out.println(ceil);
        double floor = Math.floor(2.2);
        System.out.println(floor);
    }


}
