package com.xu.basic.genericity;

/**
 * @author xuhongda on 2018/7/24
 * com.xu.basic.genericity
 * javase-practice
 */
public class ArrayAlg {

    static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (String s : a) {
            if (min.compareTo(s) > 0) {
                min = s;
            }
            if (max.compareTo(s) < 0) {
                max = s;
            }
        }
        return new Pair<>(min,max);
    }

    /**
     * 泛型方法
     * 类型变量放在修饰符（这里是 public static) 的
     * 后面，返回类型的前面
     */
    static<T>T getMiddle(T... a){
        return a[(a.length)/2];
    }

    /**
     * 类型变量限定
     */
    public static <T extends Comparable> T min(T[] a) // almost correct
    {
        if (a ==  null || a.length == 0) {
            return null;
        }
        T smallest = a[0] ;
        for (int i = 1; i < a.length; i ++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }

}
