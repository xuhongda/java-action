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
            } else if (i < 15) {
                usaInc = new BigDecimal("1.015");
                chinaInc = new BigDecimal("1.03");
                vInc = new BigDecimal("1.045");
                v = v.multiply(vInc);
                usa = usa.multiply(usaInc);
                china = china.multiply(chinaInc);
            } else if (i < 30) {
                usaInc = new BigDecimal("1.005");
                chinaInc = new BigDecimal("1.015");
                vInc = new BigDecimal("1.02");
                v = v.multiply(vInc);
                usa = usa.multiply(usaInc);
                china = china.multiply(chinaInc);
            }

            boolean flag = false;

            if (Math.abs(v.subtract(usa).doubleValue()) < 1000) {
                log.info("usa == v;year = {};value = {}", i, v.doubleValue());
                flag = true;
            }

            if (Math.abs(v.subtract(china).doubleValue()) < 1000) {
                log.info("china == v;year = {};value = {}", i, v.doubleValue());
                flag = true;
            }

            if (Math.abs(china.subtract(usa).doubleValue()) < 1000) {
                log.info("china == usa;year = {};value = {}", i, china.doubleValue());
                flag = true;
            }

            if (i > 50) {
                log.info("The three country's GDP will not equal in recent 100 years");
                flag = true;
            }

            if (flag) {
                break;
            }
        }

    }

    @Test
    public void test002() {
        double abs = Math.abs(-0.06);
        System.out.println(abs);
    }

    /**
     * 收益计算
     */
    @Test
    public void test003() {

        BigDecimal initial = new BigDecimal("1");

        BigDecimal factor = new BigDecimal("1.3");

        int years = 0;
        boolean f = true;
        for (; ; ) {
            years++;
            //倍数
            initial = initial.multiply(factor);
            BigDecimal initialM = new BigDecimal("300000");
            //金额
            initialM = initialM.multiply(initial);

            log.info("year ={} ,now value = {},now money = {}", years, initial.doubleValue(), initialM);

            if (initial.subtract(new BigDecimal("1")).doubleValue() >= 1) {
                if (f) {
                    log.info("After {} years the value have double ", years);
                }
                f = false;
            }

            if (years == 10) {
                break;
            }
        }
    }


}
