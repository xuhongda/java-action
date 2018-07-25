package com.xu.param;

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

        //浅拷贝
        Object clone = ll.clone();
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



    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("xx");
        ParamTest2 paramTest2 = new ParamTest2();
        paramTest2.method1(list);
        System.out.println(list);
    }
}
