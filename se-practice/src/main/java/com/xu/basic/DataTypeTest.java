package com.xu.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * <p>
 * double 与 float 精度问题
 * </p>
 *
 * @author xuhongda on 2018/11/22
 * com.xu.num
 * java-action
 */
@Slf4j
public class DataTypeTest {


    /**
     * 取值范围：byte 1 byte;short 2 bytes;int 8 bytes; long 8 bytes
     */
    @Test
    public void testByte(){
        // byte  一个字节 八位 取值范围 -128~127
        byte b = 127;
       // byte b = 128;
        System.out.println(b);


    }

    @Test
    public void test1() {
        Float f1 = 96515.84F;
        Float f2 = 568.19F;
        float f = f1 - f2;
        log.info("{}", f);
        BigDecimal num1 = new BigDecimal(Float.toString(f1));
        BigDecimal num2 = new BigDecimal(Float.toString(f2));
        BigDecimal subtract = num1.subtract(num2);
        log.info("{}", subtract.floatValue());

    }

    @Test
    public void test2() {
        Float f1 = 11032.51f;
        Float f2 = 80800.240f;
        Float f3 = 8700.00f;
        Float f4 = 0f;
        Float f5 = 802400.040f;
        Float f6 = 0f;
        float v = f1 * f2 + f3 * f4 + f5 * f6;
        float ff = v / f2 + f4 + f6;
        log.info("{}", ff);

        BigDecimal b1 = new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(Float.toString(f2));
        BigDecimal b3 = new BigDecimal(Float.toString(f3));
        BigDecimal b4 = new BigDecimal(Float.toString(f4));
        BigDecimal add = b1.multiply(b2).add(b3.multiply(b4));
        BigDecimal divide = add.divide(b2.add(b4), 2, 4);
        log.info("{}", divide.floatValue());

    }

    @Test
    public void test3() {
        Float f1 = 12493401276.86F;
        Float f2 = 49758.53F;
        BigDecimal b1 = new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(Float.toString(f2));
        BigDecimal divide = b1.divide(b2, 2, 4);
        log.info(divide.toString());
        Float f = f1 / f2;
        log.info("{}", f);
    }

    @Test
    public void test4() {
        float f = 0;
        int i = 4;
        float v1 = f / i;
        log.info("{}", v1);
        try {
            float v2 = i / f;
            log.info("{}", v2);
        } catch (Exception e) {
            log.info("{}", e);
        }
    }

    /**
     * 强制类型转换
     */
    @Test
    public void test5() {
        int i = 3;
        //(int)(x+4.5)
        i += 4.5;
        log.info("{}", i);
    }
}
