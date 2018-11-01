package com.xu.wrapper;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xuhongda on 2018/10/31
 * com.xu.wrapper
 * javase-practice
 */
public class BigTest {
    /**
     * bigDecimal 除法
     */
    @Test
    public void test1() {
        Float f = 0F;
        Integer integer = 5;
        BigDecimal bigDecimal = new BigDecimal(f);
        BigDecimal bigDecimal1 = new BigDecimal(integer);
        System.out.println(bigDecimal1.divide(bigDecimal, 2, 4).floatValue());
    }
}
