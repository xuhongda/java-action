package com.xu.lambda.book.appleCase;

import lombok.ToString;

/**
 * @author xuhongda on 2018/7/26
 * com.xu.lambda.book
 * javase-practice
 */
@ToString
public class Apple {

    private String color;

    private Integer weight;

    public Apple() {
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public  String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }

}
