package com.xu.lambda.self.impl;

/**
 * @author xuhongda on 2018/7/28
 * com.xu.lambda.self.impl
 * javase-practice
 */
@FunctionalInterface
public interface StringFunction<T,R> {
    /**
     * 行为
     * @param e
     * @return
     */
    R ec(T e);
}
