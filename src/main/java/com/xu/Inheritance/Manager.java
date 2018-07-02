package com.xu.Inheritance;

/**
 * @author xuhongda 2018/6/27
 * com.xu.Inheritance
 * javase-practice
 */
public class Manager extends Employee {
    private double bonus;

    public Manager() {
        this.setAge("28");
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, String age, double salary, double bonus) {
        //调用父类构造器
        super(name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
