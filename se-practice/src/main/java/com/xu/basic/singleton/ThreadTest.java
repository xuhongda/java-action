package com.xu.basic.singleton;

import com.xu.lambda.self.bean.Girl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2018/8/23
 * com.xu.basic.singleton
 * javase-practice
 */
public class ThreadTest {


    public static void main(String[] args) throws Exception {

        //验证单列模式是否线程安全
        List<Girl> girls1 = new ArrayList<>();
        List<Girl> girls2 = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            executorService.submit(()->{
                Girl girl1 = null;
                Girl girl2 = null;
                try {
                     girl1 = SingletonLanHan.getInstance();
                     girl2 = SingletonErHan.getInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                girls1.add(girl1);
                girls2.add(girl2);
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){

        }

        girls1.forEach(g-> girls1.forEach(g2->{
            boolean b = g == g2;
            System.out.println("懒汉线程安全："+b);
            if (!b){
                System.out.println(g + "\t"+g2);
                if (g!=null&&g2!=null){
                    System.out.println(g.hashCode()+"\t"+g2.hashCode());
                }
            }
        }));


        girls2.forEach(g-> girls2.forEach(g2->{
            boolean b = g == g2;
            System.out.println("饿汉汉线程安全："+b);
            if (!b){
               System.out.println(g + "\t"+g2);

            }
        }));


    }
}
