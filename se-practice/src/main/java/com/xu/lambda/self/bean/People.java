package com.xu.lambda.self.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda.self.bean
 * javase-practice
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    private String name;
    private String age;
    private String sex;

    public Boolean sex(){
        return true;
    }
}
