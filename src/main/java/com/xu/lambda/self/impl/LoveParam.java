package com.xu.lambda.self.impl;

import com.xu.lambda.self.service.Love;
import com.xu.lambda.self.service.LoveLove;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda.self.impl
 * javase-practice
 */
public class LoveParam {
    private static final int I = 100;

    /**
     * 把接口作为一个参数
     * @param love
     * @return
     */
    public Boolean love(Love love){
        System.out.println("hello love");
        //在这里可以实现自己想做的事情
        for (int i = 0;i<I;i++){
            System.out.println(love.hashCode());
            System.out.println(i);
        }
        return true;
    }

    public Boolean loveLove(LoveLove loveLove){
        System.out.println("hello loveLove");
        return true;
    }
}
