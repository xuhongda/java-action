package com.jvm;

import java.util.*;
/**
 * @author xuhongda on 2021/5/31
 * com.jvm
 * java-action
 */
public class MyMap {

    public static void main(String[] args) throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        int i =0;
        while (true){
            Thread.sleep(500);
            map.put(String.valueOf(i++),i);
        }
    }
}
