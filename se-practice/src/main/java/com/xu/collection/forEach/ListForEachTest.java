package com.xu.collection.forEach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/10/24
 * com.xu.collection.forEach
 * javase-practice
 */
@Slf4j
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


    @Test
    public void test2() {
        List<Integer> list = new ArrayList();
        List<Integer> list1 = m1(list);
        for (Integer o : list1) {
            list1.add(o);
        }

    }

    private void t(Integer o) {
        List<Integer> list = new ArrayList();
        List<Integer> list1 = m1(list);
        for (Integer i : list1) {
            i = i + o;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Thread.sleep(3000);

        executorService.submit(() -> {
            log.info("{}",Thread.currentThread().getName());
            ArrayList<Integer> integers = map.get(1);
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(1);
            map.put(1, integers);
        });

        executorService.submit(() -> {
            log.info("{}",Thread.currentThread().getName());
            ArrayList<Integer> integers = map.get(1);
            if (integers != null) {
                integers.add(8);
                map.remove(1);
            }
            map.put(1,integers);
            map.put(2, list);
            for (Integer i:integers){}
        });


        executorService.shutdown();
        while (true) {
            boolean terminated = executorService.isTerminated();
            if (terminated) {
                System.out.println(map);
                break;
            }
        }
    }


    @Test
    public void test5(){
        Timestamp startTime = new Timestamp(0);
        System.out.println(startTime);
    }


    @Test
    public void  test9(){


        if (true){
            System.out.println("1");

            ListForEachTest.t();
        }else {
            System.out.println("2");
        }


        if (true){
            System.out.println("3");
        }
    }

    private static String t(){
        return "444";
    }

}
