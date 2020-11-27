package com.xu.lambda.self.impl;

/**
 * @author xuhongda on 2018/7/28
 * com.xu.lambda.self.impl
 * javase-practice
 * <p>
 * @link com.google.common.base.Function
 * </p>
 */
@FunctionalInterface
public interface MyFunction<T,R> {
    /**
     * 行为
     * @param e 参数
     * @return r return result
     */
    R ec(T e);
}
