package com.xu.collection;

import java.util.ArrayList;

/**
 * @author xuhongda 2018/6/27
 * com.xu.collection
 * javase-practice
 */
public class MyArrayList extends ArrayList {
    public MyArrayList(){}

    public MyArrayList(int i){
        //调用父类构造器
        super(i);
    }
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.ensureCapacity(2000000);
        long start = System.currentTimeMillis();
        for (int i = 0; i <2000000 ; i++) {
            list.add(i);
        }
        list.trimToSize();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
