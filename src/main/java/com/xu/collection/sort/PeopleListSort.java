package com.xu.collection.sort;

import com.xu.pojo.People;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>List 排序 匿名对象方式，也可以创建实列对象</p>
 * @author xuhonda on 2018/7/9
 * com.xu.collection.sort
 * javase-practice
 */
public class PeopleListSort {
    public static void main(String[] args) {
        List<People> peoples = new ArrayList<>();
        List<People> peoples2 = new ArrayList<>();
        People people1 = new People("x",1);
        People people2 = new People("x",2);
        People people3 = new People("x",3);
        People people4 = new People("x",4);
        peoples.add(people1);
        peoples.add(people2);
        peoples.add(people3);
        peoples.add(people4);
        peoples2.add(people1);
        peoples2.add(people2);
        System.out.println(peoples);
        peoples.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.getAge() > o2.getAge()){
                    return -1;
                }else if (o1.getAge() <= o2.getAge()){
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(peoples);
        //两个集合的交集
        System.out.println(peoples.retainAll(peoples2));
        System.out.println(peoples);
    }
}
