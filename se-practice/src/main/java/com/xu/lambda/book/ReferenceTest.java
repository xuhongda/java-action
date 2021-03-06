package com.xu.lambda.book;

import pojo.People;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * lambda 表达式 方法引用
 * @author xuhongda on 2018/7/30
 * com.xu.lambda.book
 * javase-practice
 */
public class ReferenceTest {

    @Test
    public void test(){
        List<People> list = Arrays.asList(new People("xx",18),new People("cc",20));
        list.sort(Comparator.comparing(p->p.getAge()));
        list.sort(Comparator.comparing(People::getAge));
        System.out.println(list);
    }

    /**
     * 构造器引用
     */
    @Test
    public void test2(){
        Supplier<People> supplier = People::new;
        People people =supplier.get();
        System.out.println(people.toString());
    }
}
