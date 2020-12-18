package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import pojo.People;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/11/1
 * com.xu.collection
 * javase-practice
 */
@Slf4j
public class ListTest {

    private static List<People> list = new ArrayList<>();

    static {
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(new People("x" + i, i));
        }
    }

    @Test
    public void test(){
        list.forEach(System.out::println);
    }

    /**
     * 空集合需要注意一些问题
     */
    @Test
    public void test1() {
        list.clear();
        System.out.println(list.size());
        try{
            People people = list.get(0);
            System.out.println(people);
        }catch (Exception e){
            log.info("exception",e);
        }finally {
            List<People> collect = list.stream().filter(a -> a.getAge() > 18).collect(Collectors.toList());
            System.out.println(collect);
        }
    }

    /**
     * 动态变化
     */
    @Test
    public void test2() {
        Runnable r = () -> list.forEach(a -> a.setName("yan"));
        r.run();
    }

    @Test
    public void test3() {
        People people = new People();
        people.setName(null);
        String name = people.getName();
        System.out.println(name);
    }


    @Test
    public void  test4(){
        ConcurrentSkipListMap<Object, Object> canMap = new ConcurrentSkipListMap<>();

        canMap.put(1,1);
        canMap.put(2,1);
        canMap.put(3,1);
        Object value = canMap.firstEntry().getValue();
        System.out.println(value);
        ConcurrentNavigableMap<Object, Object> objectObjectConcurrentNavigableMap =
                canMap.headMap(2);
        System.out.println(objectObjectConcurrentNavigableMap);
        int i = canMap.headMap(2).size();
        System.out.println(i);
    }


    /**
     * remove
     */
    @Test
    public void test5(){
        People remove = list.remove(4);
        System.out.println(list);
        System.out.println(remove);
    }

    /**
     * stack and heap differ with a lambda
     */
    public static void main(String[] args) {
        int i = 5;
        int i2 = 3;
        People p = new People("yan",18);
        Calculate<Integer,People> c1 =  (x, y)->{
            y.setAge(y.getAge()+i);
            System.out.println(y);
        };
        Calculate<Integer,Integer> c2 =  (x, y)->{
            y=x+y;
            System.out.println(y);
        };
        c1.copy(i,p);
        System.out.println(p);
        c2.copy(i,i2);
        System.out.println(i2);
    }

}

@FunctionalInterface
interface Calculate<T, R> {
    /**
     * one action to manipulate t and r
     * @param t any params
     * @param r any params
     */
    void copy(T t,R r);

}


