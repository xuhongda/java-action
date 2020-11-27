package com.xu.basic.singleton;

/**
 * <p>
 *     单列模式，懒汉式,线程不安全
 * </p>
 * @author xuhongda on 2018/8/23
 * com.xu.basic.singleton
 * javase-practice
 */
public class SingletonLanHan {
    private static SingletonLanHan singletonLanHan = null;

    private SingletonLanHan() {
    }

    /**
     * 在多线程条件下，（== null） 可能多个线程成立，导致单列失效
     * @return SingletonLanHan
     */
    public static SingletonLanHan getInstance(){
        if (singletonLanHan == null){
            System.out.println("懒汉式创建对象");
           singletonLanHan = new SingletonLanHan();
        }
        return singletonLanHan;
    }
}
