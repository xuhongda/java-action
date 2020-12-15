package com.xu.basic;

/**
 * @author xuhongda on 2020/11/26
 * com.xu.basic
 * java-action
 */

import java.util.Scanner;
public class HomePay03 {
    public static void main(String[] args) {
        int sum=10000;
        String account1=null;
        String account2=null;
        int getSalary=0;
        int pay=0;
        boolean b =true;
        boolean b2 = true;
        for(int i=0;i<8;i++){
            System.out.print("-");
        }
        System.out.print("家庭收支管理系统");
        for(int i=0;i<8;i++){
            System.out.print("-");
        }
        int i =0;
        while(b){
            if (i == 0){
                System.out.println();
                System.out.println("\t"+"1.收支明细");
                System.out.println("\t"+"2.登记收入");
                System.out.println("\t"+"3.登记支出");
                System.out.println("\t"+"4.退出");
                System.out.print("请输入(1-4):");
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
                while(b2){
                    System.out.print("是否要退出(Y/N):");
                    Scanner s = new Scanner(System.in);
                    String str = s.nextLine();
                    if("Y".equals(str)){
                        b2=false;
                        b=false;
                    }else if("N".equals(str)){
                        break;
                    }
                }
            } else if(i==2){
                System.out.print("收入：");
                Scanner s2 = new Scanner(System.in);
                try {
                    getSalary=s2.nextInt();
                    sum+=getSalary;
                    s2.nextLine();
                    System.out.print("本次收入说明：");
                    account1 = s2.nextLine();
                    i=0;
                }catch (Exception e){
                    System.out.println("请输入数字");
                    i =2;
                }
            } else if(i==3){
                System.out.print("本次支出金额：");
                Scanner s3 = new Scanner(System.in);
                pay = s3.nextInt();
                s3.nextLine();
                System.out.print("本次支出说明：");
                account2=s3.nextLine();
                System.out.println();
                i=0;
            }else if(i==1){
                for(int i2=0;i2<8;i2++){
                    System.out.print("*");
                }
                System.out.print("当前收支明细记录");
                for(int i2=0;i2<8;i2++){
                    System.out.print("*");
                }
                System.out.println();
                System.out.println( "收支\t账户金额\t收支金额\t说    明\n");
                System.out.println("收入"+sum+"\t"+getSalary+"\t"+account1);
                System.out.println("支出"+sum+"\t"+pay+"\t"+account2);
                System.out.println();
                i=0;
            }	else{
                System.out.println("输入错误请重新输入");
            }
        }
    }
}

