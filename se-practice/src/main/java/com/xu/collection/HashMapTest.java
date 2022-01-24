package com.xu.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.Girl;

import java.util.*;
import java.util.function.Function;

/**
 * @author xuhongda on 2019/6/26
 * com.xu.collection
 * java-action
 */
@Slf4j
public class HashMapTest {


    private HashMap<Integer,Integer> map;

    {
      map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,7);
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
     * computeIfAbsent if the map not has the kay then add it to map
     */
    @Test
    public void test4(){

        Function<Integer,Integer> function = a -> 777;

        map.computeIfAbsent(999,function);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.forEach(a->log.info("{}",a));
    }

    /**
     * merge if key equals then the value multiply
     */
    @Test
    public void test5(){

        map.merge(4,888, Integer::sum);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.forEach(a->log.info("{}",a));

    }

    @Test
    public void test6(){
        List<Integer> integers = Arrays.asList(1, 1,1, 2, 2, 3, 3,4,5);
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : integers){
            Integer key = i;
            if (map.containsKey(key)){
                Integer integer = map.get(key);
                i=integer+i;
            }
            map.put(key,i);
        }
        System.out.println(map);
    }


    /**
     *  统计集合相同属性和的方法
     */
    @Test
    public void test7(){
        Girl girl1 = new Girl("yan",18,50.0);
        Girl girl2 = new Girl("yan",18,50.0);
        Girl girl3 = new Girl("xu",18,50.0);
        Girl girl4 = new Girl("xu",20,60.0);
        List<Girl> girlList = new ArrayList<>();
        girlList.add(girl1);
        girlList.add(girl2);
        girlList.add(girl3);
        girlList.add(girl4);

        Map<Integer,Girl> map = new HashMap<>();
        for (Girl girl : girlList){
            Girl girlResp = new Girl();
            girlResp.setAge(girl.getAge());
            girlResp.setName(girl.getName());
            Integer key = girl.getAge();
            if (map.containsKey(key)){
                double weight = girl.getWeight();
                Girl girlValue = map.get(key);
                weight+=girlValue.getWeight();
                girlResp.setWeight(weight);
            }else {
                girlResp.setWeight(girl.getWeight());
            }
            map.put(key,girlResp);
        }
        System.out.println(map);

    }
}
