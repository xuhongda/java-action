package com.xu.genericity;

import org.junit.Test;

import java.io.Serializable;

/**
 * 泛型类测试
 * @author xuhongda on 2018/7/24
 * com.xu.genericity
 * javase-practice
 */
public class PairTest1 {

    @Test
    public void test(){
        String[] words = {"yan", "xu", "jack", "cr7"};
        Pair<String> pair = ArrayAlg.minmax(words);
        System.out.println(pair.getFirst());
        System.out.println(pair.getScond());
    }
    @Test
    public void test2(){
        String middle = ArrayAlg.getMiddle("xx", "dd","xx");
        System.out.println(middle);
    }
    @Test
    public void test3(){
        //参数是多种类型，包装和String 都实现了 Serializable 接口
        Serializable xx = ArrayAlg.getMiddle(1.22, 44,0.66,"zzz");
        System.out.println(xx);
    }
}
