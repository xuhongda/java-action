package com.xu.reflect;

import org.junit.Test;
import pojo.Constants;
import pojo.Girl;
import pojo.LoveMe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuhongda on 2020/11/19
 * com.xu.reflect
 * java-action
 */
public class Reflect {


    /**
     * 获得 Class 对象三种方法
     */
    @Test
    public void test001(){

        Class<Girl> girlClass = Girl.class;

        Girl girl = new Girl();
        Class<? extends Girl> aClass = girl.getClass();

        try {
            Class<?> forName = Class.forName("pojo.Girl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * getFields ... 只返回 public ；getDeclaredFields 返回所有但不包括超类的成员
     */
    @Test
    public void test002(){

        Class<Girl> girlClass = Girl.class;

        String name = girlClass.getName();
        System.out.println(name);

        Method[] methods = girlClass.getMethods();

        for (Method m: methods){
            System.out.println("method = "+m);
        }


       // Field[] fields = girlClass.getFields();

        Field[] fields = girlClass.getDeclaredFields();

        for (Field f: fields){
            System.out.println("field = "+f);
        }

        Constructor<?>[] constructors = girlClass.getConstructors();
        for (Constructor c: constructors){
            System.out.println("constructor = "+c);
        }
    }


    @Test
    public void test003(){

        Class<Girl> girlClass = Girl.class;

        Field[] fields = girlClass.getDeclaredFields();
        Field field = fields[0];

        try {
            field.setAccessible(true);
            Girl girl = new Girl();
            girl.setName("yan");
            String name = (String)field.get(girl);
            System.out.println(name);
            LoveMe annotation = field.getAnnotation(LoveMe.class);

            if (Constants.ME.getValue().equals(annotation.name())){
                field.set(girl,girl.getName()+" love "+annotation.name());
                System.out.println(girl);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        try {
            Method method = girlClass.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);
            Girl girl = new Girl();
            method.invoke(girl,"liulizhen");
            System.out.println(girl);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
