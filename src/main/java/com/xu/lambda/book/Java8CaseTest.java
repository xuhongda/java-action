package com.xu.lambda.book;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Function;

/**
 * @author xuhongda on 2018/7/29
 * com.xu.lambda.book
 * javase-practice
 */
public class Java8CaseTest {
    /**
     * 一个参数，一个返回值
     * 接口 {@link Function}
     */
    @Test
    public void test1(){
        Function<String,Integer> function = (String s ) -> s.length();
        Integer i = function.apply("xxx");
        System.out.println(i);
    }

    /**
     * 没有参数，没有返回值
     * 接口 {@link Runnable}
     */
    @Test
    public void test2(){
       Runnable runnable = ()-> System.out.println("lamda");
       runnable.run();
    }

    /**
     * 两个参数，没有返回值
     *
     */
    @Test
    public void test3(){
      Test3<Integer,Integer,Integer> t = (x, y)->{
          PrintStream out = System.out;
          out.println("x+y");
          return x+y;
        };
        t.x(18,20);
    }

    interface  Test3<T,R,E>{
        /**
         * x
         * @param t
         * @param r
         */
        E x(T t,R r);
    }
}
