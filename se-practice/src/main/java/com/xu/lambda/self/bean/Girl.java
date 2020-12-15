package com.xu.lambda.self.bean;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda.self.bean
 * javase-practice
 */

public class Girl {
    private String name;

    public Integer age;

    public Girl() {
    }

    public Girl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
