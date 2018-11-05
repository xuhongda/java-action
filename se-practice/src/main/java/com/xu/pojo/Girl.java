package com.xu.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/11/5
 * com.xu.pojo
 * javase-practice
 */
@Data
@ToString
public class Girl implements Serializable {

    private String name;

    private int age;

    private transient double weight;
}
