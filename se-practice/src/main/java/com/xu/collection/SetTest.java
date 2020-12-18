package com.xu.collection;

import org.junit.Test;
import pojo.Girl;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * HashSet & TreeSet
 * @author xuhongda on 2018/6/17
 * com.xu.collection
 * javase-practice
 */
public class SetTest {

    /**
     * <p>use hashSet to find repetition numbers in an array because
     * the HashSet is consisted of HashMap, the hashMap has hashcode algorithm
     * the repetition numbers can't save</p>
     *
     *  <p>hashSet is disorder</p>
     *
     */
    @Test
    public void test001(){

        HashSet<Integer> hashSet = new HashSet<>();
        int [] arr = {1,1,2,3,4,5,5,7,9,6,5,11};
        HashSet<Integer> repetitions = new HashSet<>();
        for (int value : arr) {
            boolean add = hashSet.add(value);
            if (!add) {
                repetitions.add(value);
            }
        }
        System.out.println(hashSet);
        System.out.println(repetitions);

    }

    /**
     *  TreeSet
     *  implements comparator interface to decide two objects weather equals.
     */
    @Test
    public void test002(){

        Comparator<Girl> comparator = (o1,o2)->{
            if (o1 == null || o2 == null){
                return 0;
            }

            if (o1.getName().equals(o2.getName()) && o1.getAge() == o2.getAge()){
                return 0;
            }
            return 1;
        };

        Girl girl1 = new Girl("yan",18,50);
        Girl girl2 = new Girl("yan",18,50);
        Girl girl3 = new Girl("yan",19,50);
        TreeSet<Girl> treeSet = new TreeSet<>(comparator);
        treeSet.add(girl1);
        treeSet.add(girl2);
        treeSet.add(girl3);
        treeSet.add(null);
        System.out.println(treeSet);

    }

}
