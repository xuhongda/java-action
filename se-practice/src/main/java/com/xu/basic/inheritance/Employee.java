package com.xu.basic.inheritance;

/**
 * @author xuhongda 2018/6/27
 * com.xu.basic.inheritance
 * javase-practice
 */
public class Employee {
    private String name;
    private String age;
    private double salary;
    protected String home;
    public Employee() {
        this.age = "18";
    }

    public Employee(String name, String age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
