package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.Girl;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xuhongda on 2019/5/13
 * com.xu.collection
 * java-action
 */
@Slf4j
public class ConcurrentSkipListMapTest {

    private  ConcurrentSkipListMap<Object,Object> map;

    {
       log.info("init...");
       map  = new ConcurrentSkipListMap<>();
    }

    @Test
    public void test001(){
        map.put("1",new Girl("yan",18,50));
        map.put("2",2);
        map.put("3",2);
        map.put("4",new Girl("yan",18,50));
        log.info("map = {}",map);
    }
}
