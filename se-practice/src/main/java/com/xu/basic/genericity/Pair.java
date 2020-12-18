package com.xu.basic.genericity;


/**
 * 泛型类
 * 泛型类可看作普通类的工厂
 * @author xuhongda on 2018/7/24
 * com.xu.basic.genericity
 * javase-practice
 */
public class Pair<T> {

    private T first;

    private T second;

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

}
