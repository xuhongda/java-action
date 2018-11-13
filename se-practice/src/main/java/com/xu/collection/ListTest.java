package com.xu.collection;

import com.xu.pojo.People;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author xuhongda on 2018/11/1
 * com.xu.collection
 * javase-practice
 */
public class ListTest {

    private List<People> list = new ArrayList<>();

    {
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(new People("x" + i, i));
        }
    }

    /**
     * 空集合需要注意一些问题
     */
    @Test
    public void test1() {
        list.clear();
        boolean empty = list.isEmpty();
        Assert.assertEquals(true, empty);
        list.get(0);
        list.stream().filter(a -> a.getAge() > 18);
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

}
