package com.xu.basic.inheritance;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuhongda 2018/6/27
 * com.xu.basic.inheritance
 * javase-practice
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void test001(){
        Employee employee = new Manager();
        //会调用 Manager 的方法
        String age = employee.getAge();
        log.info("age = {}",age);
    }
}
