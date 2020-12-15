package com.xu.basic.singleton;

import com.xu.lambda.self.bean.Girl;

/**
 * <p>
 *     单列模式，懒汉式,线程不安全
 * </p>
 * @author xuhongda on 2018/8/23
 * com.xu.basic.singleton
 * javase-practice
 */
public class SingletonLanHan {
    /**
     *  成员变量
     */
    private static  Girl girl = null;

    private SingletonLanHan() {
    }

    /**
     * 在多线程条件下，（== null） 可能多个线程成立，导致单列失效
     * @return SingletonLanHan
     */
    public static Girl getInstance() throws InterruptedException {
        if (girl == null){
            System.out.println("懒汉式创建对象");
            Thread.sleep(10);
           girl = new Girl("only",18);
        }
        return girl;
    }

    public static void main(String[] args) throws InterruptedException {
        Girl instance = getInstance();
        System.out.println(instance);
    }
}
