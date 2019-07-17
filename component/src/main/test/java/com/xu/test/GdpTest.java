package com.xu.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xuhongda on 2019/7/17
 * com.xu.test
 * java-action
 */
@Slf4j
public class GdpTest {

    @Test
    public void test() {


        BigDecimal usa = new BigDecimal("62600");
        BigDecimal usaInc = new BigDecimal("1.015");


        BigDecimal china = new BigDecimal("9800");
        BigDecimal chinaInc = new BigDecimal("1.050");


        BigDecimal v = new BigDecimal("2563");
        BigDecimal vInc = new BigDecimal("1.067");


        int i = 0;

        for (; ; ) {

            i++;
            if (i < 10) {
                v = v.multiply(vInc);
                usa = usa.multiply(usaInc);
                china = china.multiply(chinaInc);
            } else if ( i < 15) {
                usaInc = new BigDecimal("1.005");
                chinaInc = new BigDecimal("1.025");
                vInc = new BigDecimal("1.035");
                v = v.multiply(vInc);
                usa = usa.multiply(usaInc);
                china = china.multiply(chinaInc);
            } else {
                usaInc = new BigDecimal("1");
                chinaInc = new BigDecimal("1.001");
                vInc = new BigDecimal("1.015");
                v = v.multiply(vInc);
                usa = usa.multiply(usaInc);
                china = china.multiply(chinaInc);
            }


            if (Math.abs(v.subtract(usa).doubleValue()) < 1000) {
                log.info("usa == v;year = {};value = {}", i, v.doubleValue());
                //  break;
            }

            if (Math.abs(v.subtract(china).doubleValue()) < 1000) {
                log.info("china == v;year = {};value = {}", i, v.doubleValue());
                // break;
            }

            if (Math.abs(china.subtract(usa).doubleValue()) < 1000) {
                log.info("china == usa;year = {};value = {}", i, china.doubleValue());
                // break;
            }
        }

    }

    @Test
    public void test002() {
        double abs = Math.abs(-0.06);
        System.out.println(abs);
    }
}
