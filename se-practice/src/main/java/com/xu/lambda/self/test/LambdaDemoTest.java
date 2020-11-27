package com.xu.lambda.self.test;

import com.google.common.base.Function;
import com.xu.lambda.self.impl.MyFunction;
import pojo.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/7/28
 * com.xu.lambda.self.test
 * javase-practice
 */
public class LambdaDemoTest {
    @Test
    public void test(){

        List<String> list = Arrays.asList("method","zA","cc");


        MyFunction<String,String> myFunction = String::toUpperCase;
        List<String> list1 = method(list, myFunction);
        list1.parallelStream().forEach(System.err::print);

        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("method","zA","cc");
        //需求一：。。。
        List xx = LambdaDemoTest.method(list, String::toLowerCase);
        System.out.println(xx);
        //需求二：。。。
        LambdaDemoTest.method(list, s->s.charAt(1));
        //
        List<People> peopleList = Arrays.asList(new People("method", 12), new People("vv", 18));
        List xuhongda = LambdaDemoTest.method(peopleList, p->"xuhongda".equals(p.getName()));
        System.out.println(xuhongda);
        //
        peopleList.sort(Comparator.comparing(people -> people.getAge()>=18));
    }

    /**
     *
     * @param list  集合参数
     * @param myFunction  接口参数
     * @param <T>
     * @param <R>
     * @return list
     */
    private static <T,R>List<R> method(List<T> list, MyFunction<T, R> myFunction){
        List<R> list1 = new ArrayList<>();
        for (T s : list){
            R ec = myFunction.ec(s);
            list1.add(ec);
        }
        return list1;
    }

    @Test
    public void test3(){
       Runnable runnable = () -> System.out.println("run");
       runnable.run();
    }

    /**
     * MyFunction<People, String> peopleObjectFunction = (People p) -> p.getName().toUpperCase();
     * 函数式接口：MyFunction<People, String> peopleObjectFunction
     * 函数式接口里的方法参数：(People p)
     * 方法行为： p.getName().toUpperCase()
     *
     * MyFunction 是我自定义的的接口，它接收一个类型参数返回一个类型结果
     * 其实在JDK 1.8 中提供了 Function 接口
     *
     */
    @Test
    public void test4(){
        MyFunction<People, String> peopleObjectFunction = (People p) -> p.getName().toUpperCase();
        String xxx = peopleObjectFunction.ec(new People("xxx", 18));
        System.out.println(xxx);

        List<People> peopleList = Arrays.asList(new People("method", 12), new People("vv", 18));
        List xx = LambdaDemoTest.method(peopleList, peopleObjectFunction);
        System.out.println(xx);
    }

}
