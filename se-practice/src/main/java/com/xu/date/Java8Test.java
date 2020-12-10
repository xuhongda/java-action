package com.xu.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @author xuhongda on 2020/12/7
 * com.xu.date
 * java-action
 */
public class Java8Test {

    @Test
    public void test001(){
        LocalDate date = LocalDate.of(2020, 12, 7);
        System.out.println(date);
        int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
        int dayOfMonth = date.getDayOfMonth();
        System.out.println(dayOfMonth);
        int i = date.lengthOfMonth();
        System.out.println(i);
        //闰年
        boolean leapYear = date.isLeapYear();
        System.out.println(leapYear);



    }


    @Test
    public void test002(){
        LocalDate date = LocalDate.of(2020, 12, 7);
        int year = date.get(ChronoField.YEAR);
        System.out.println(year);
        int i = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        System.out.println(i);
    }


    @Test
    public void test003(){
        LocalTime time = LocalTime.of(10, 29, 33);
        System.out.println(time);
    }

}
