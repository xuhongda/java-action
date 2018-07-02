package com.xu.pdf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
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
        String str = "信用卡  \n";
        System.out.println(str.length());
    }

    @org.junit.Test
    public void test003(){
        String s = "{\\\"cacheFlag\\\":true,\\\"resultData\\\":\\\"{\\\\\\\"creditCardDetailsList\\\\\\\":[{\\\\\\\"detail\\\\\\\":[\\\\\\\"2018年5月28日中国农业银行发放的贷记卡（美元账户）。截至2018年5月,信用额度折合人民币19,689，已使用额度0。\\\\\\\",\\\\\\\"2013年3月2日广州农村商业银行发放的贷记卡（人民币账户）。截至2018年5月，信用额度50,000，已使用额度49,611。\\\\\\\",\\\\\\\"2012年7月26日平安银行信用卡中心发放的贷记卡（人民币账户）。截至2018年6月，信用额度3,000，已使用额度0。\\\\\\\",\\\\\\\"2007年9月14日招商银行发放的贷记卡（人民币账户）。截至2018年5月，信用额度100,000，已使用额度91,992。\\\\\\\",\\\\\\\"2007年9月14日招商银行发放的贷记卡（美元账户）。截至2018年5月,信用额度折合人民币100,000，已使用额度0。\\\\\\\",\\\\\\\"2007年9月6日中国工商银行嘉兴市分行发放的贷记卡（人民币账户），截至2015年4月已销户。\\\\\\\",\\\\\\\"2002年12月30日中国建设银行北京市分行发放的准贷记卡（人民币账户），截至2016年5月已销户。\\\\\\\",\\\\\\\"1998年2月18日中国工商银行嘉兴市分行发放的准贷记卡（人民币账户），截至2015年4月已销户。\\\\\\\",\\\\\\\"2018年5月28日中国农业银行发放的贷记卡（人民币账户）。截至2018年5月，信用额度20,000，尚未激活。\\\\\\\"],\\\\\\\"heading\\\\\\\":\\\\\\\"从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细如下：\\\\\\\",\\\\\\\"loanType\\\\\\\":\\\\\\\"信用卡\\\\\\\"}";


    }
}
