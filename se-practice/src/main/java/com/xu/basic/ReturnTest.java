package com.xu.basic;

/**
 * @author xuhongda on 2020/8/18
 * com.xu.load
 * java-action
 */
public class ReturnTest {

    public static void main(String[] args) {
        m(1);

        System.out.println("123");
    }

    private static void m(Integer i){

        if (i>0){
            return;
        }
        System.out.println("xx");
    }
}
