package com.xu.lambda.self.test;

import com.xu.lambda.self.bean.Man;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/10/10
 * com.xu.lambda.self.test
 * javase-practice
 */
@Slf4j
public class StreamTest {
    private List<Man> mans = new ArrayList<>();

    @Before
    public void before() {
        for (int i = 0; i < 99; i++) {
            double random = Math.random() * 100;
            Man man = new Man(i, random, "formal");
            mans.add(man);
        }
    }

    /**
     * map
     * <p>
     *     根据条件对list 里每个元素进行操作
     * </p>
     */
    @Test
    public void test() {
        List<Man> collect = mans.parallelStream().map(a -> {
            if (a.getWeight() > 50) {
                a.setAge(18);
                a.setName("modify");
                return a;
            }
            a.setAge(7);
            return a;
        }).collect(Collectors.toList());
        log.info("map 后： {}", collect);
        log.info("原先： {}", mans);
        log.info("{}", collect == mans);
    }

    /**
     * filter
     */
    @Test
    public void test2() {
        mans.parallelStream().filter(a -> a.getWeight() > 50).forEach(System.out::println);
    }

    /**
     * sorted
     * <p>
     * 注意：sorted 不能用 parallelStream
     * </p>
     */
    @Test
    public void test3() {
        mans.stream().sorted(Comparator.comparing(Man::getWeight)).forEach(System.out::println);
    }

    /**
     * limit
     */
    @Test
    public void test4() {
        mans.parallelStream().limit(10).forEach(System.out::println);
    }


    /**
     * forEach
     * <p>
     * 两个list 根据条件合并为同一个list
     * </p>
     */
    @Test
    public void test6() {
        List<Man> list = new ArrayList<>();
        List<Man> mens = Arrays.asList(new Man(18, 93.0, "f"), new Man(1, 32.0, "f"));

        mans.parallelStream().forEach(a -> {
            mens.parallelStream().forEach(man -> {
                if (man.getAge() > 5) {
                    list.add(man);
                }
            });

            if (a.getWeight() > 10) {
                list.add(a);
            } else if (a.getAge() > 10) {
                a.setWeight(80.0);

            }
        });
        System.out.println(list);
    }

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5);
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        System.out.println(collect);
        Collection<Long> values = collect.values();
        for (Long num : values) {
            if (num > 1) {
                System.out.println(num);
                throw new RuntimeException("具有重复数");
            }
        }
    }

}
