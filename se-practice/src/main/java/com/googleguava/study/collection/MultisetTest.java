package com.googleguava.study.collection;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.xu.pojo.People;
import org.junit.Test;

import java.util.Set;


/**
 * @author xuhongda on 2018/7/24
 * com.googleguava.study.collection
 * javase-practice
 */
public class MultisetTest {
    @Test
    public void test001(){

        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.add("11");
        wordsMultiset.add("11");
        wordsMultiset.add("11");
        wordsMultiset.add("22");
        int count = wordsMultiset.count("11");
        System.out.println(count);
        //
        Set set = wordsMultiset.elementSet();
        System.out.println(set);
    }

    @Test
    public void test2(){

        Multiset<People> peopleMultiset = HashMultiset.create();
        People people;
        for (int i = 0; i <100; i++) {
            people = new People("xx"+i,i);
            peopleMultiset.add(people);
        }
        People people1 = new People("xx1",1);
        People people2 = new People("xx1",1);
        People people3 = new People("xx1",1);
        peopleMultiset.add(people1);
        peopleMultiset.add(people2);
        peopleMultiset.add(people3);
        System.out.println(peopleMultiset);
        System.out.println(peopleMultiset.count(people1));
    }
}
