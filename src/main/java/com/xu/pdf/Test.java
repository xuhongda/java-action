package com.xu.pdf;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuhongda 2018/6/28
 * com.xu.pdf
 * javase-practice
 */
public class Test {
    @org.junit.Test
    public void test(){
        String phoneString = "哈哈,13888889999 3333";
        // 提取数字
        // 1
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(phoneString);
        String all = matcher.replaceAll("@");
        System.out.println("phone:" + all);
        // 2
        Pattern.compile("[^0-9]").matcher(phoneString).replaceAll("");
    }
    @org.junit.Test
    public void test2(){
        Map map = new HashMap();
        map.put("1","xxx");
        map.put("2","dd");
        map.put("3","ff");
        System.out.println(map);
    }
    @org.junit.Test
    public void test3(){
        String str = "说 明";
        System.out.println(str.length());
    }

    @org.junit.Test
    public void test003(){
        String s = "'sds gdasda" + "\n" + "edaeafd'";
        System.out.println("转换前："+s);
        s = s.replaceAll("\r|\n", "");
        System.out.println("转换后："+s);

    }
    @org.junit.Test
    public void test006(){
        Map map1 = null;
        Map map2 = null;
        Map map3 = null;
        for (int i = 0; i < 1000000000; i++) {
            for (int j= 0;j<1000000000;j++){
                map1 = new HashMap(100000);
                map2 = new HashMap(100000);
                map3 = new HashMap(100000);
                map1.put(i,i);
                map2.put(i,i);
                map3.put(i,i);
            }
        }
    }

    @org.junit.Test
    public void test007(){
        Map map = new HashMap();
        map.put(1,"me");
        Object o = map.get(0);
        o.getClass();
    }
    @org.junit.Test
    public void test008(){
        List<String> aList = Arrays.asList("1","2","3","4","5");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
       /* for (String string : aList) {
            System.out.println(string);
        }*/
        for (int i = aList.size();i>0;i--){
            System.out.println(aList.get(i-1));
        }
    }

}
