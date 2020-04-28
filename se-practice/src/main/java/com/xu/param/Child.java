package com.xu.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xuhongda on 2020/4/22
 * com.xu.param
 * java-action
 */
@Setter
@Getter
public class Child extends Parent {

    private String childName;

    public Child(String childName) {
        this.childName = childName;
    }
    public Child(int age, String name) {
        super(age, name);
        childName = name +"xxx";
        

    }

    public static void main(String[] args) {
        Child child = new Child(10,"yyy");
        System.out.println();
    }
}
