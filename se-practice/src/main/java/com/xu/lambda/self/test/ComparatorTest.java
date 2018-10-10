package com.xu.lambda.self.test;

import com.xu.lambda.self.bean.Apple;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/10/10
 * com.xu.lambda.self.test
 * javase-practice
 */
public class ComparatorTest {
    List<Apple> list = new ArrayList<>();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            double random = Math.random() * 10;
            int v = (int) random * 100 + i;
            Apple apple = new Apple(v, "cn");
            list.add(apple);
        }
    }

    /**
     * lambda 排序
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 23, 445, 66, 56, 7, 787, 8, 85, 3, 9);
        list.sort((Integer::compareTo));
        System.out.println(list);
    }

    @Test
    public void test2() {
        list.sort(Comparator.comparing(Apple::getWeight));
        //接着比较
        list.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getAddress));
        //反转
        list.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(list);
    }

    @Test
    public void test3() {
        List<Apple> collect = list.parallelStream().filter(a -> a.getWeight() > 100).collect(Collectors.toList());
        System.out.println(collect);
    }

}
