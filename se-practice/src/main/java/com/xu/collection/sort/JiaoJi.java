package com.xu.collection.sort;

import pojo.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author xuhongda on 2018/10/25
 * com.xu.collection.sort
 * javase-practice
 */
public class JiaoJi {
    @Test
    public void test1() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        list2.add(5);
        list2.add(7);
        // 交集
        List<Integer> intersection = list1.stream().filter(list2::contains).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.forEach(System.out::println);

    }

    @Test
    public void test() {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People();
            people.setName(Integer.toString(i));
            people.setAge(i);
            peoples.add(people);
        }
        Map<Integer, String> map = new HashMap<>(10);
        peoples.forEach(a -> {
            Integer age = a.getAge();
            String name = a.getName();
            map.put(age, name);
        });
        System.out.println(map);
    }
}
