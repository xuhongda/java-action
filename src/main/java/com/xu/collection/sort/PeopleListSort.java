package com.xu.collection.sort;

import com.xu.pojo.People;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>List 排序 匿名对象方式，也可以创建实列对象</p>
 *
 * @author xuhonda on 2018/7/9
 * com.xu.collection.sort
 * javase-practice
 */
public class PeopleListSort {
    List<People> peoples;

    @Before
    public void before() {
        peoples = new ArrayList<>();
        People people1 = new People("x", 1);
        People people2 = new People("x", 2);
        People people3 = new People("x", 3);
        People people4 = new People("x", 4);
        peoples.add(people1);
        peoples.add(people3);
        peoples.add(people4);
        peoples.add(people2);
        System.out.println("before" + peoples);
    }

    @Test
    public void test1() {
        peoples.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
               /* if (o1.getAge() > o2.getAge()){
                    return -1;
                }else if (o1.getAge() <= o2.getAge()){
                    return 1;
                }*/
                //包装类型 如 Integer 重写了compareTo 方法直接复用
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println("test1" + peoples);
    }

    @Test
    public void test2() {
        //java8 提供的新写法;意思是给peoples集合排序，比较 people 的 年龄
        peoples.sort(Comparator.comparing(People::getAge));
        //或者这样，调用reversed方法倒序
        Collections.sort(peoples, Comparator.comparing(People::getAge).reversed());
        System.out.println("test2" + peoples);
    }

    @Test
    public void test3() {
        //lamda 表达
        peoples.sort((People p1, People p2) -> p1.getAge().compareTo(p2.getAge()));
        //可以简化,编译器会推断类型
        peoples.sort((p1,p2)->p1.getAge().compareTo(p2.getAge()));
        //提取comparator，调用reversed方法倒序
        Comparator<People> comparator =  (p1,p2) -> p1.getAge().compareTo(p2.getAge());
        peoples.sort(comparator.reversed());
        System.out.println(peoples);
    }

}
