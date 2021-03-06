package com.xu.lambda.book;

import org.junit.Test;

/**
 * @author xuhongda on 2018/7/29
 * com.xu.lambda.book
 * javase-practice
 */
public class Java8CaseTest {
    /**
     * 一个参数，一个返回值
     * 接口 {@link java.util.function.Function}
     */
    @Test
    public void test1() {
        java.util.function.Function<String,Integer> function = String::length;
        Integer i = function.apply("xxx");
        System.out.println(i);
    }

    /**
     * 没有参数，没有返回值
     * 接口 {@link Runnable}
     */
    @Test
    public void test2() {
        Runnable runnable = () -> System.out.println("lambda");
        runnable.run();
    }

    /**
     * 体现 lambda 表达式思想的示例。
     */
    @Test
    public void test3() {
        //
        MyFunction<Integer, Integer, Integer> t = Integer::sum;
        Integer x = t.todoSomething(18, 20);
        System.out.println(x);

        //
        MyFunction<String,String,String> t2 = (p1, p2)-> p1 +"\t" + p2;
        String count = t2.todoSomething("xu", "girl");
        System.out.println(count);

    }
    @FunctionalInterface
    interface MyFunction<T, R, E> {
        /**
         *一个接口方法，只需规定参数个数与返回结果.
         * @param t param 1
         * @param r param 2
         * @return E 具体返回得到什么，取决于实现方式.
         */
        E todoSomething(T t, R r);
    }
}
