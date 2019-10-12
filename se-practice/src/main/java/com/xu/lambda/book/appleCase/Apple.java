package com.xu.lambda.book.appleCase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2018/7/26
 * com.xu.lambda.book
 * javase-practice
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Apple {

    private String color;

    private Integer weight;

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }

}
