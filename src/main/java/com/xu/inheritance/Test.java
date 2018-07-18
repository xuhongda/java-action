package com.xu.inheritance;

/**
 * @author xuhongda 2018/6/27
 * com.xu.inheritance
 * javase-practice
 */
public class Test {
    @org.junit.Test
    public void test001(){
        Employee employee = new Manager();
        //会调用 Manager 的方法
        String age = employee.getAge();
    }
}
