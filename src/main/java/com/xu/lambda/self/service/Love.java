package com.xu.lambda.self.service;

import com.xu.lambda.self.bean.Girl;
import com.xu.lambda.self.bean.People;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda.self.service
 * javase-practice
 */
@FunctionalInterface
public interface Love {
    /**
     * lambda表达式测试方法
     * @param people
     * @return
     */
    Boolean loveYou(People people);

    //lambda表达式只支持一个拥有一个函数的接口;使用@FunctionalInterface标注函数式接口，在编译时提前发现错误。
    //Boolean loveMe(Girl girl);
}
