package com.xu.param;

/**
 * @author xuhongda on 2018/7/25
 * com.xu.param
 * javase-practice
 */
public class ParamTest1 {
    public static void function1(int i,int j){
        int temp=i;
        i=j;
        j =temp;
        System.out.println("function1方法里"+" i是"+i+"j是"+j);
    }
    public static void function2(int a,int b){
        a++;
        b++;
    }
    public static void main(String[] args) {
        int a=1;
        int b=2;
        function1(a,b);
        function2(a ,b);
        //存在于不同的内存区间中
        System.out.println(a+" "+b);
    }

}
