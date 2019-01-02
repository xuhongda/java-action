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
        List list = new ArrayList();
        List list2 = new ArrayList();
        List m1 = m1(list);
        List m2 = m2(list2);
        List list3 = new ArrayList();
        Object collect = m1.parallelStream().map(a -> {
            Integer i = (Integer) a + 2;
            //list3将会是无序的
            list3.add(i);
            return i;
        }).collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(collect);
        System.out.println(list3);
        System.out.println(s);
    }

    List m1(List list) {
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        return list;
    }

    List m2(List list) {
        for (int i = 0; i < 9; i++) {
            list.add(i + 1);
        }
        return list;
    }
}
