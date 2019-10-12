package com.xu.lambda.self.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.xu.lambda.book.appleCase.Apple;
import util.ListToJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
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
@Slf4j
public class ComparatorTest {

    private List<Apple> list = new ArrayList<>();

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            double random = Math.random() * 10;
            int v = (int) random * 100 + i;
            Apple apple = new Apple(v, "red","cn");
            list.add(apple);
        }
    }

    /**
     * lambda 排序
     */
    @Test
    public void test1() throws IOException {
        List<Integer> list = Arrays.asList(1, 23, 445, 66, 56, 7, 787, 8, 85, 3, 9);
        list.sort((Integer::compareTo));
        log.info(ListToJsonUtil.listToJson(list));
    }

    @Test
    public void test2() throws JsonProcessingException {
        list.sort(Comparator.comparing(Apple::getWeight));
        //接着比较
        list.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getAddress));
        //反转
        list.sort(Comparator.comparing(Apple::getWeight).reversed());

        log.info("list = {}",mapper.writeValueAsString(list));
    }

    @Test
    public void test3() throws JsonProcessingException {
        List<Apple> collect = list.parallelStream().filter(a -> a.getWeight() > 100).collect(Collectors.toList());
        log.info("collect = {}",mapper.writeValueAsString(collect));
    }

}
