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
    public void test(){



        BigDecimal usa = new BigDecimal("62600");
        BigDecimal usaInc = new BigDecimal("1.015");


        BigDecimal china = new BigDecimal("9800");
        BigDecimal chinaInc = new BigDecimal("1.050");


        BigDecimal v = new BigDecimal("2563");
        BigDecimal vInc = new BigDecimal("1.067");


        int i = 0;

        for (;;) {

            i++;
            v = v.multiply(vInc);
            usa = usa.multiply(usaInc);
            china  = china.multiply(chinaInc);


            if (Math.abs(v.subtract(usa).doubleValue()) < 1500){
                System.out.println(i);
                System.out.println(v.doubleValue());
                log.info("usa == v");
              //  break;
            }

            if (Math.abs(v.subtract(china).doubleValue())< 1500){
                System.out.println(i);
                System.out.println(china);
                log.info("china == v");
               // break;
            }

            if (Math.abs(china.subtract(usa).doubleValue())<1500){
                System.out.println(i);
                System.out.println(china);
                log.info("china == usa");
               // break;
            }
        }

    }

    @Test
    public void test002(){
        double abs = Math.abs(-0.06);
        System.out.println(abs);
    }
}
