package com.xu.lambda.self.lambda;

import com.xu.lambda.self.bean.Girl;
import com.xu.lambda.self.bean.People;
import com.xu.lambda.self.impl.LoveParam;
import com.xu.lambda.self.service.Love;
import com.xu.lambda.self.service.LoveLove;
import org.junit.Test;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda.self.lambda
 * javase-practice
 */
public class SelfTest {
    @Test
    public void test(){

        //formal
        new LoveParam().love(new Love() {
            @Override
            public Boolean loveYou(People people) {
                return true;
            }
        });

        //lambda  变量--》变量里的方法
        new LoveParam().love(people -> true);

        new LoveParam().love(People::sex);


    }
    @Test
    public void test2(){
        new LoveParam().loveLove(new LoveLove());
    }
}
