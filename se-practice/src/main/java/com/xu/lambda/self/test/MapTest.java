package com.xu.lambda.self.test;

import com.xu.lambda.self.bean.Man;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author xuhongda on 2018/12/26
 * com.xu.lambda.self.test
 * java-action
 */
@Slf4j
public class MapTest {

    private List<Man> mans = new ArrayList<>();

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            double random = Math.random() * 100;
            Man man = new Man(i, random, "formal");
            mans.add(man);
        }
    }

    @Test
    public void test1() {
        // List<Double> collect = mans.stream().map(Man::getWeight).collect(toList());
        List<Double> collect = new ArrayList<>();

        log.info("{}", collect);
        //reduce 操作
        Optional<Double> max = collect.stream().reduce(BinaryOperator.maxBy(Comparator.comparing(a -> a)));
        Optional<Double> min = collect.stream().reduce(BinaryOperator.minBy(Comparator.comparing(a -> a)));
        log.info("{}", max.isPresent());
        log.info("{}", min.get());
    }


    @Test
    public void test2() {
        Optional<Man> manOptional = Optional.empty();
        log.info("{}", manOptional.isPresent());
    }

    @Test
    public void test3() {
        Man man = new Man(18, 60.0, "xu");
        Optional<Man> manOptional = Optional.of(man);
        log.info("{}", manOptional.isPresent());
    }
}
