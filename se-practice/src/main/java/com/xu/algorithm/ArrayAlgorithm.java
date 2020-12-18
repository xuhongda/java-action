package com.xu.algorithm;

import com.xu.basic.genericity.Pair;

/**
 * @author xuhongda on 2018/7/24
 * com.xu.basic.genericity
 * javase-practice
 */
public class ArrayAlgorithm {

    /**
     *
     * @param a a String array
     * @return min and max String array
     */
    public static Pair<String> minmax(String[] a){
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
     * @return return the middle number in arrays
     */
    @SafeVarargs
    public static<T>T getMiddle(T... a){
        return a[(a.length)/2];
    }

    /**
     * @return  return the minimum number in the arrays while the params must implements {@link Comparable }
     */
    public static <T extends Comparable> T min(T[] a)
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
