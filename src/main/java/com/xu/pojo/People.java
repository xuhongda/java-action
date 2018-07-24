package com.xu.pojo;

/**
 * @author xuhonda on 2018/7/9
 * com.xu.pojo
 * javase-practice
 */

public class People {
    private String name;
    private Integer age;

    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == null){
            return false;
        }
        if (!(obj instanceof People)){
            return false;
        }
        if (this == obj){
            return true;
        }
        People people = (People) obj;
        return  this.getAge() .equals(people.getAge())  && this.getName().equals(people.getName());
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result =1;
        result =prime*result+age;
        result=prime*result+((name==null)?0:name.hashCode());
        return result;

    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
