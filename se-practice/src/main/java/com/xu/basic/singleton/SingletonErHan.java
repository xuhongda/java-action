package com.xu.basic.singleton;

import com.xu.lambda.self.bean.Girl;

/**
 * <p>
 *     饿汉式
 * </p>
 * @author xuhongda on 2018/8/23
 * com.xu.basic.singleton
 * javase-practice
 */
public class SingletonErHan {

    private static final Girl girl = new Girl("only",18);

    private SingletonErHan(){}

    public static Girl getInstance(){
        System.out.println("饿汉式获取对象");
        return girl;
    }

    public static void main(String[] args) {
        Girl instance = getInstance();
        System.out.println(instance);
    }
}
