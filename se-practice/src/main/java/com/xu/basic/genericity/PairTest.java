package com.xu.basic.genericity;

import com.xu.algorithm.ArrayAlgorithm;
import org.junit.Test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 泛型类测试
 * @author xuhongda on 2018/7/24
 * com.xu.basic.genericity
 * javase-practice
 */
public class PairTest {

    @Test
    public void test(){
        String[] words = {"yan", "xu", "jack", "cr7"};
        Pair<String> pair = ArrayAlgorithm.minmax(words);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
    @Test
    public void test2(){
        String middle = ArrayAlgorithm.getMiddle("xx", "dd","xx");
        System.out.println(middle);
    }
    @Test
    public void test3(){
        //参数是多种类型，包装和String 都实现了 Serializable 接口
        Serializable xx = ArrayAlgorithm.getMiddle(1.22, 44,0.66,"zzz");
        System.out.println(xx);
    }

    @Test
    public void test4(){
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance1.setTime(new Date(99999L));
        instance2.setTime(new Date(10000L));
        Calendar [] array = {instance1,instance2};
        Calendar min = ArrayAlgorithm.min(array);
        System.out.println(min.getTime());
    }
}
