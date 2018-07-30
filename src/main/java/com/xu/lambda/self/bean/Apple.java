package com.xu.lambda.self.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author xuhongda on 2018/7/30
 * com.xu.lambda.self.bean
 * javase-practice
 */
@ToString
@Data
public class Apple {

    Integer weight;

    String address;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(int weight, String address) {
        this.weight = weight;
        this.address = address;
    }
}
