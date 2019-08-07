package com.xu.param;

import pojo.People;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2018/7/25
 * com.xu.param
 * javase-practice
 */
public class ParamTest2 {

    public void method1(List list){
        ArrayList ll = (ArrayList) list;

        //浅拷贝???
        Object clone = ll.clone();
        System.out.println(clone == list);
        method2(list);
        System.out.println(list);
        System.out.println(clone);
    }
    public List method2(List list){

        List list1 = new ArrayList();
        list1.add("yy");
        list.addAll(list1);
        return list1;
    }

    public void method3(List<People> list){
        ArrayList ll = (ArrayList) list;
        Object clone = ll.clone();
        method4(list);
        System.out.println(ll == list);
        System.out.println(list);
        System.out.println(clone);
    }

    public List method4(List<People> list){
        List<People> list1 = new ArrayList();
        list1.add(new People("liu",18));
        list.addAll(list1);
        return list1;
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("xx");
        ParamTest2 paramTest2 = new ParamTest2();
        paramTest2.method1(list);
        System.out.println(list);
        /**/
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("xx",18));
        paramTest2.method3(peopleList);
    }



}
