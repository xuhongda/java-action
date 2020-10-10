package com.xu.wrapper;

import org.junit.Test;
import pojo.Girl;

/**
 * @author xuhongda on 2020/10/9
 * com.xu.wrapper
 * java-action
 */
public class Tt {

    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.setAge(18);

        boolean b = m(girl);
        System.out.println(girl);
    }

    private static boolean m(Girl girl) {
        girl.setWeight(18.8);
        return true;
    }

    @Test
    public void test(){
        /*String s ="34.3";

        Double aDouble = Double.valueOf(s);
        System.out.println(aDouble.intValue());*/


        int i = (int)3.6*44/5;
        System.out.println(i);
    }
}
