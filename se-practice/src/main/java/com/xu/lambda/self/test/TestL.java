package com.xu.lambda.self.test;

import com.google.common.base.Function;
import com.xu.lambda.self.impl.StringFunction;
import com.xu.pojo.People;
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
public class TestL {
    @Test
    public void test(){
        List<String> list = Arrays.asList("xx","zA","cc");

        Function<String,String> function = (String s) -> s.toUpperCase();

        List<String> collect = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("xx","zA","cc");
        //需求一：。。。
        List xx = TestL.xx(list, s -> s.toLowerCase());
        System.out.println(xx);
        //需求二：。。。
        TestL.xx(list,s->s.charAt(1));
        //
        List<People> peopleList = Arrays.asList(new People("xx", 12), new People("vv", 18));
        List xuhongda = TestL.xx(peopleList, p->"xuhongda".equals(p.getName()));
        System.out.println(xuhongda);
        //
        peopleList.sort(Comparator.comparing(people -> people.getAge()>=18));
    }

    public static <T,R>List xx(List<T> list, StringFunction<T,R> stringFunction){
        List list1 = new ArrayList();
        for (T s : list){
            R ec = stringFunction.ec(s);
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
     * StringFunction<People, String> peopleObjectFunction = (People p) -> p.getName().toUpperCase();
     * 函数式接口：StringFunction<People, String> peopleObjectFunction
     * 函数式接口里的方法参数：(People p)
     * 方法行为： p.getName().toUpperCase()
     *
     * StringFunction 是我自定义的的接口，它接收一个类型参数返回一个类型结果
     * 其实在JDK 1.8 中提供了 Function 接口
     *
     */
    @Test
    public void test4(){
        StringFunction<People, String> peopleObjectFunction = (People p) -> p.getName().toUpperCase();
        String xxx = peopleObjectFunction.ec(new People("xxx", 18));
        System.out.println(xxx);

        List<People> peopleList = Arrays.asList(new People("xx", 12), new People("vv", 18));
        List xx = TestL.xx(peopleList, peopleObjectFunction);
        System.out.println(xx);
    }

}
