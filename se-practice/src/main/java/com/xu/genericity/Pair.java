package com.xu.genericity;


/**
 * 泛型类
 * 泛型类可看作普通类的工厂
 * @author xuhongda on 2018/7/24
 * com.xu.genericity
 * javase-practice
 */
public class Pair<T> {

    private T first;

    private T scond;

    public Pair() {
    }

    public Pair(T first, T scond) {
        this.first = first;
        this.scond = scond;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getScond() {
        return scond;
    }

    public void setScond(T scond) {
        this.scond = scond;
    }

}
