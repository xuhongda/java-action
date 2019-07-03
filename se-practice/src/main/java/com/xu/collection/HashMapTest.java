package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * @author xuhongda on 2019/6/26
 * com.xu.collection
 * java-action
 */
@Slf4j
public class HashMapTest {


    HashMap<Integer,Integer> map;

    {
      map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
    }

    /**
     * 遍历 key
     */
    @Test
    public void test(){
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        // 迭代器
        while (iterator.hasNext()){
            Integer next = iterator.next();
            log.info("key = {}",next);
        }
        // 直接 for
        for(Integer integer : integers){
            log.info("key = {}",integer);
        }
    }


    @Test
    public void test2(){
        Collection<Integer> values = map.values();
        values.forEach(v-> log.info("value = {}",v));
    }


    @Test
    public void test3(){
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.forEach(a->log.info("{}",a.getValue()));
    }

    /**
     * computeIfAbsent 缺啥补啥
     */
    @Test
    public void test4(){

        Function<Integer,Integer> function = a -> 777;

        map.computeIfAbsent(999,function);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.forEach(a->log.info("{}",a));
    }
}
