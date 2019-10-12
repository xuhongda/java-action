package com.xu.lambda.book.appleCase;


import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;


/**
 * @author xuhongda on 2018/7/26
 * com.xu.lambda.book.appleCase
 * javase-practice
 */
@Slf4j
public class AppleTest {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>(3);
        Apple apple1 = new Apple("green",160);
        Apple apple2 = new Apple("red",140);
        Apple apple3 = new Apple("yellow",160);
        Apple apple4 = new Apple("yellow", 10);
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);


        List list = filterApples(apples, AppleTest::isGreenApple);
        System.out.println(list);

        List list1 = filterApples(apples, (Apple a) -> "yellow".equals(a.getColor()));
        System.out.println(list1);

        List list2 = filterApples(apples, (Apple a) -> a.getWeight() >140 );
        System.out.println(list2);

        List list3 = filterApples(apples, (Apple a) -> a.getWeight() > 140 && "yellow".equals(a.getColor()));
        System.out.println(list3);

        List list4 = filterApples(apples, Apple::isHeavyApple);
        System.out.println(list4);

        List<Apple> collect = apples.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(toList());

        log.info("collect = {} ",collect);

    }

    /**
     *
     * @param inventory 一个集合
     * @param p 作为参数
     * @return 集合
     */
    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 传统的筛选方法
     * @param inventory list
     * @return list
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    private static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
}
