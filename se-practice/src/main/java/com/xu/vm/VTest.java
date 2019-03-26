package com.xu.vm;

import com.xu.lambda.self.bean.People;

import java.util.Collections;
import java.util.List;

public class VTest {

    public static void main(String[] args) {
        System.out.println(m().size());
        System.out.println("...");
    }

    private static List<People>  m() {
        List<People> people = Collections.singletonList(new People("1", "2", "3"));
        return people;
    }
}
