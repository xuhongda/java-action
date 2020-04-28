package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xuhongda on 2019/5/13
 * com.xu.collection
 * java-action
 */
@Slf4j
public class ConcurrentSkipListMapTest {

    private ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();

    {
        log.info("init...");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
    }



    @Test
    public void test005() {

        log.info("map = {}",map);
        ConcurrentNavigableMap<String, String> headMap = map.headMap("4");
        System.out.println(headMap);
        NavigableSet<String> set = headMap.keySet();
        /*for (String s : set){
            map.remove(s);
        }*/
        String higher = set.higher("2");
        log.info("higher = {}",higher);
        headMap.clear();
        System.out.println(map);

    }


    @Test
    public void test006() {
        Map.Entry<String, String> stringStringEntry = map.higherEntry("3");
        System.out.println(stringStringEntry.getValue());
    }


    @Test
    public void test007() {

        log.info("map = {}",map);
        ConcurrentNavigableMap<String, String> headMap = map.headMap("4");
        headMap.clear();
        map.remove("4");
        System.out.println(map);

    }


    @Test
    public void test008() {

        Map.Entry<String, String> stringStringEntry = map.firstEntry();
        System.out.println(stringStringEntry);

    }


    @Test
    public void test009() {

        ConcurrentNavigableMap<String, String> headMap = map.headMap("4",true);
        System.out.println(headMap);

    }
}
