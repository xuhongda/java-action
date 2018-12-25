package com.xu.num;

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
public class FloatTest {
    @Test
    public void test1() {
        Float f1 = 96515.84F;
        Float f2 = 568.19F;
        float f = f1 - f2;
        System.out.println(f);
        BigDecimal num1 = new BigDecimal(Float.toString(f1));
        BigDecimal num2 = new BigDecimal(Float.toString(f2));
        BigDecimal subtract = num1.subtract(num2);
        System.out.println(subtract.floatValue());

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
        System.out.println(ff);

        BigDecimal b1 = new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(Float.toString(f2));
        BigDecimal b3 = new BigDecimal(Float.toString(f3));
        BigDecimal b4 = new BigDecimal(Float.toString(f4));
        BigDecimal add = b1.multiply(b2).add(b3.multiply(b4));
        BigDecimal divide = add.divide(b2.add(b4), 2, 4);
        System.out.println(divide.floatValue());

    }

    @Test
    public void test3() {
        Float f1 = 12493401276.86F;
        Float f2 = 49758.53F;
        BigDecimal b1 = new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(Float.toString(f2));
        BigDecimal divide = b1.divide(b2, 2, 4);
        System.out.println(divide.toString());
        Float f = f1 / f2;
        System.out.println(f);
    }
}
