package com.xu.singleton;

/**
 * <p>
 *     饿汉式
 * </p>
 * @author xuhongda on 2018/8/23
 * com.xu.singleton
 * javase-practice
 */
public class SingletonErHan {

    private static SingletonErHan singletonErHan = new SingletonErHan();

    private SingletonErHan(){}

    public static SingletonErHan getInstance(){
        return singletonErHan;
    }


}
