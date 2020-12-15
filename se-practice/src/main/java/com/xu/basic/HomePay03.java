package com.xu.basic;

/**
 * @author xuhongda on 2020/11/26
 * com.xu.basic
 * java-action
 */

import java.util.Scanner;
public class HomePay03 {
    public static void main(String[] args) {
        int sum=0;
        String sumInfo=null;
        String payInfo=null;
        int getSalary=0;
        int pay=0;
        boolean b =true;
        for(int i=0;i<8;i++){
            System.out.print("-");
        }
        System.err.print("家庭收支管理系统");
        for(int i=0;i<8;i++){
            System.out.print("-");
        }
        int i =0;
        StringBuilder inDetails = new StringBuilder();
        StringBuilder outDetails =new StringBuilder();
        while(b){

            if (i == 0){
                System.out.println();
                System.err.println("\t"+"1.收支明细");
                System.err.println("\t"+"2.登记收入");
                System.err.println("\t"+"3.登记支出");
                System.err.println("\t"+"4.退出");
                System.err.print("请输入(1-4):");
                try{
                    Scanner s1 = new Scanner(System.in);
                    i =s1.nextInt();
                    System.out.println("已输入:"+i);
                    System.out.println();
                }catch (Exception e){
                    i= 0;
                }
            }

            if(i==4){
                boolean exit = true;
                while(exit){
                    System.err.print("是否要退出(Y/N):");
                    Scanner s = new Scanner(System.in);
                    String str = s.nextLine();
                    if("Y".equals(str.toUpperCase())){
                        exit=false;
                        b=false;
                    }else if("N".equals(str.toUpperCase())){
                        break;
                    }
                }
            }

            else if(i==2){
                System.err.print("收入：");
                Scanner s2 = new Scanner(System.in);
                try {
                    getSalary=s2.nextInt();
                    sum+=getSalary;
                    s2.nextLine();
                    System.err.print("本次收入说明：");
                    sumInfo = s2.nextLine();
                    inDetails.append(sumInfo).append(":").append(getSalary).append("\t");
                    i=0;
                }catch (Exception e){
                    System.err.println("请输入数字!");
                    i =2;
                }
            } else if(i==3){
                if (sum>0){
                    System.err.print("本次支出金额：");
                    Scanner s3 = new Scanner(System.in);
                    int out = s3.nextInt();
                    int k = sum -out;
                    if (k>0){
                        pay+=out;
                        sum = sum -out;
                        s3.nextLine();
                        System.err.print("本次支出说明：");
                        payInfo=s3.nextLine();
                        System.err.println();
                        outDetails.append(payInfo).append(":").append(pay).append("\t");
                    }else {
                        System.err.println("余额不足！");
                    }
                }

                i=0;
            }else if(i==1){
                for(int i2=0;i2<8;i2++){
                    System.err.print("*");
                }
                System.err.print("当前收支明细记录");
                for(int i2=0;i2<8;i2++){
                    System.err.print("*");
                }
                System.err.println();
                System.err.println( "收支\t账户金额\t收支金额\t说    明\n");
                System.err.println("剩余："+sum+"\t"+"收入明细："+inDetails.toString());
                System.err.println("支出："+pay+"\t"+"开支明细："+outDetails.toString());
                System.err.println();
                i=0;
            }	else{
                System.err.println("输入错误请重新输入");
                i=0;
            }
        }
    }
}

