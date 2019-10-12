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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Apple {

    private Integer weight;

    private String color;

    private String address;


    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }

}
