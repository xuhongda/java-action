package com.xu.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda on 2019/6/3
 * com.xu.math
 * java-action
 */
@Slf4j
public class MathTest {

    @Test
    public void test(){
        //把数字转换为角度
        double v = Math.toRadians(30d);
        //sin
        double asin = Math.sin(v);
        System.out.println(asin);
        //cos
        double cos = Math.cos(v);
        System.out.println(cos);
    }

    /**
     * 反正弦函数
     */
    @Test
    public void test1(){
        double asin = Math.asin(1);
        System.out.println(asin);
    }

    /**
     * 平方根   --->>>2
     */
    @Test
    public void test2(){
        double sqrt = Math.sqrt(4);
        System.out.println(sqrt);
    }

    /**
     * 2 的 2 次方
     */
    @Test
    public void test3(){
        double pow = Math.pow(2,2);
        System.out.println(pow);
    }

    /**
     *  绝对值
     */
    @Test
    public void test4(){
        double abs = Math.abs(-9);
        System.out.println(abs);
    }

    /**
     *  返回最大值/最小值
     */
    @Test
    public void test5(){
        double ceil = Math.ceil(2.2);
        System.out.println(ceil);
        double floor = Math.floor(2.2);
        System.out.println(floor);
    }

    @Test
    public void test6(){
        double hypot = Math.hypot(3, 4);
        System.out.println(hypot);
    }

    @Test
    public void test7(){
        double hypot = Math.hypot(Math.hypot(0.2, -0.1), 1);
        System.out.println(hypot);
    }

    @Test
    public void test8(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String ,Object> map;
        for (int i = 0; i <3 ; i++) {
            //构建三个 map 临时变量，这两种写法有何不同，这勾起了我的疑惑
            // 只是一个赋值语句 ，无区别？
           // Map<String ,Object> map = new HashMap<>(3);
            map = new HashMap<>(3);
            map.put("x"+i,i);
            list.add(map);
        }
        list.forEach(System.out::println);

    }

}
