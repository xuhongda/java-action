package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.Girl;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xuhongda on 2019/5/13
 * com.xu.collection
 * java-action
 */
@Slf4j
public class ConcurrentSkipListMapTest {

    private ConcurrentSkipListMap<Object, Object> map;

    {
        log.info("init...");
        map = new ConcurrentSkipListMap<>();
        map.put("1", 1);
        map.put("2", 2);
    }

    @Test
    public void test001() {
        map.put("1", new Girl("yan", 18, 50));
        map.put("2", 2);
        map.put("3", 2);
        map.put("4", new Girl("yan", 18, 50));
        log.info("map = {}", map);
    }


    @Test
    public void test002() {
        map.put("1", 1);
        map.put("2", 2);
        ConcurrentNavigableMap<Object, Object> objectObjectConcurrentNavigableMap = map.descendingMap();
        log.info("map = {}", objectObjectConcurrentNavigableMap);
    }


    @Test
    public void test003() {
        map.put("xx", "yy");
        Object o = map.ceilingKey("3");
        log.info("object  = {}", o);
    }

    /**
     * pollFirstEntry
     */
    @Test
    public void test004() {
        System.out.println(map);
        log.info("size = {}",map.size());
        Map.Entry<Object, Object> objectObjectEntry = map.pollFirstEntry();
        //Map.Entry<Object, Object> objectObjectEntry1 = map.pollLastEntry();
        Object value = objectObjectEntry.getValue();
        log.info("object  = {}", value);
        log.info("size = {}",map.size());
        System.out.println(map);
    }

}
