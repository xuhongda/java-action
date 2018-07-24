package com.googleguava.study.optional;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author xuhongda on 2018/7/24
 * com.googleguava.study
 * javase-practice
 */
public class NullTest {
    @Test
    public void test(){
        Optional<Integer> optional = Optional.of(9);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
    }

    @Test
    public void test2(){
        Optional<String> optional = Optional.of(null);
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
    }
}
