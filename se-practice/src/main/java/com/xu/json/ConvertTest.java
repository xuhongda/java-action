package com.xu.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2019/1/8
 * com.xu.json
 * java-action
 */
@Slf4j
public class ConvertTest {

    private ObjectMapper mapper = new ObjectMapper();

    private StringWriter writer = new StringWriter();

    /**
     * 对象里含有集合
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        Girl girl = new Girl();
        List<Girl> girls = new ArrayList<>();
        girls.add(girl);
        user1.setGirls(girls);
        user2.setGirls(girls);
        users.add(user1);
        users.add(user2);
        String s = mapper.writeValueAsString(users);
        log.info("s = {}", s);
        mapper.writeValue(writer, user1);
        log.info(writer.toString());
        Result<User> result = new Result<>();
        result.setData(user1);
    }


    @Test
    public void test1() throws IOException {
        Girl girl = new Girl();
        List<Girl> girls = new ArrayList<>();
        girls.add(girl);
        String str = mapper.writeValueAsString(girls);
        log.info("str = {}", str);
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Girl.class);
        List<Girl> girlList = mapper.readValue(str, collectionType);
        log.info("girlList = {}", girlList);
    }


    @Test
    public void test4() throws IOException {
        Girl girl = new Girl();
        girl.setAge(18);
        String str = mapper.writeValueAsString(girl);
        log.info("str = {}", str);
        String s = mapper.writeValueAsString(str);
        log.info("s = {}", s);
    }


    @Test
    public void test005() throws IOException {

        String str = "{\"cmd\":\"vpmsServiceDeptList\",\"result\":0,\"resultNote\":\"查询成功\",\"totalRecordNum\":1,\"pages\":1,\"pageNo\":0,\"detail\":{\"deptTree\":[{\"deptId\":\"20081313550860002D100\",\"deptName\":\"默认授权店\",\"corpId\":\"20081313550860002\"},{\"deptId\":\"20081313550860002D102\",\"deptName\":\"曲靖授权店A\",\"corpId\":\"20081313550860002\"}]}}";

        JSONObject o =  JSONObject.parseObject(str);
        System.out.println(o);

        String s =  o.getString("detail");
        System.out.println("s= "+s);
        String ss =JSONObject.parseObject(s).getString("deptTree");
        System.out.println(ss);
        /*ObjectMapper objectMapper = new ObjectMapper();

        OppenApiResult oppenApiResult = objectMapper.readValue(o.toJSONString(), OppenApiResult.class);

        System.out.println(oppenApiResult);*/
       /* IovCarInfo iovCarInfo = JSONObject.parseObject(s, IovCarInfo.class);
        System.out.println(iovCarInfo);*/
    }


    @Test
    public void test006(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd","vpmsServiceDeptList");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("corpId","20081313550860002");

        jsonObject.put("detail",jsonObject2);

        System.out.println(jsonObject.toJSONString());

    }


    @Test
    public void test007(){
        JSONObject jsonObject = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        jsonObject.put("detail",list);
        System.out.println(jsonObject.toJSONString());
    }


    @Test
    public void test008(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd","vpmsServiceDeptList");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("corpId","20081313550860002");

        jsonObject.put("detail",jsonObject2);

        System.out.println(jsonObject.toJSONString());
    }


    @Test
    public void test009(){
        String s = "{\"cmd\":\"queryVpmsDeviceDetail\",\"result\":0,\"resultNote\":\"Success\",\"totalRecordNum\":1,\"pages\":1,\"pageNo\":0,\"detail\":{\"deviceId\":\"46082901131\",\"operatorDeptId\":\"19052811581714784\",\"contractStartDate\":\"2020-09-03\",\"licensePlateNo\":\"临R007133\",\"vin\":\"LFMA1ACC6L0057852\",\"engineNumber\":\"\",\"objId\":\"20090310272410897\",\"operationStatus\":13,\"donateServicePeriod\":1}}";
        JSONObject o =  JSONObject.parseObject(s);
        String detail =  o.getString("detail");
        IovCarInfo iovCarInfo = JSONObject.parseObject(detail, IovCarInfo.class);
        System.out.println(iovCarInfo);
    }
}
