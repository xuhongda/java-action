package com.xu.lambda.self.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.ConstructorProperties;

/**
 * @author xuhongda on 2018/7/30
 * com.xu.lambda.self.bean
 * javase-practice
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Apple {


    Integer weight;
    String address;

    public Apple(Integer weight) {
        this.weight = weight;
    }
}
