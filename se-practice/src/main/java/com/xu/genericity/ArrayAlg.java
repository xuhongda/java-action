package com.xu.genericity;

/**
 * @author xuhongda on 2018/7/24
 * com.xu.genericity
 * javase-practice
 */
public class ArrayAlg {

    public static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 0; i <a.length ; i++) {
            if (min.compareTo(a[i])>0){
                min = a[i];
            }
            if (max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }

    /**
     * 泛型方法
     * 类型变量放在修饰符（这里是 public static) 的
     * 后面，返回类型的前面
     * @param a
     * @param <T>
     * @return
     */
    public static<T>T getMiddle(T...a){
        return a[(a.length)/2];
    }

    /**
     * 类型变量限定
     * @param a
     * @param <T>
     * @return
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
