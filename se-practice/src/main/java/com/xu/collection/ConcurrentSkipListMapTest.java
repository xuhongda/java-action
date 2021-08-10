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

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        log.info("init...map = {}", map);
    }


    @Test
    public void test010() {

        log.info("map = {}", map);
        map.put("7","7");
        map.put("8","7");
        String s = map.get("9");
        System.out.println(s);
        log.info("after map = {}", map);

    }

    @Test
    public void test009() {

        log.info("map = {}", map);
        map.remove("7");
        log.info("after map = {}", map);

    }

    @Test
    public void test007() {

        log.info("map = {}", map);
        map.remove("1");
        map.remove("7");
        String s = map.get("1");
        if (s == null) {
            System.out.println(s);
        }
        System.out.println(s);
        log.info("after map = {}", map);

    }


    @Test
    public void test005() {

        log.info("map = {}", map);
        ConcurrentNavigableMap<String, String> headMap = map.headMap("4");
        log.info("headMap = {}", headMap);
        NavigableSet<String> set = headMap.keySet();
        /*for (String s : set){
            map.remove(s);
        }*/
        String higher = set.higher("2");
        log.info("higher = {}", higher);
        headMap.clear();
        log.info("clear remain map = {}", map);

    }


    @Test
    public void test006() {
        Map.Entry<String, String> stringStringEntry = map.higherEntry("3");
        System.out.println(stringStringEntry);
    }


    @Test
    public void test008() {
        Map.Entry<String, String> stringStringEntry = map.firstEntry();
        System.out.println(stringStringEntry);
    }


}
