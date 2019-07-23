package com.xu.collection.forEach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/10/24
 * com.xu.collection.forEach
 * javase-practice
 */
public class ListForEachTest {
    @Test
    public void test1() throws JsonProcessingException {
        List<Integer> list = new ArrayList<>();
        List<Integer> m1 = m1(list);
        List<Integer> list3 = new ArrayList<>();
        Object collect = m1.parallelStream().map(a -> {
            Integer i = a + 2;
            //list3将会是无序的
            list3.add(i);
            return i;
        }).collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(collect);
        System.out.println(list3);
        System.out.println(s);
    }

    private List<Integer> m1(List<Integer> list) {
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        return list;
    }
}
