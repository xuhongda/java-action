package com.xu.string;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import pojo.CommonRequest;
import pojo.Detail;
import pojo.DrivingFingerprintIndexMatch;
import pojo.DrivingFingerprintIndexMatchResponse;

import java.io.IOException;
import java.util.*;

/**
 * @author xuhongda on 2018/8/31
 * com.xu.string
 * javase-practice
 */
@Slf4j
public class StringTest {

    private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void test001() {
        String s1 = "hello";
        String s2 = "he";
        String s3 = s2 + new String("llo");
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s3);
    }

    @Test
    public void test002() {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String[] arr = new String[10];
        System.out.println(arr[0]);
    }

    @Test
    public void test4() {
        String s1 = "ABC", s2 = "abv";
        int i = s1.compareTo(s2);
        System.out.println(i);
    }

    @Test
    public void test5() {
        char a = 'A';
        char b = 'B';
        Assert.assertTrue("a>b", a < b);
    }


    @Test
    public void test6() throws JsonProcessingException {
        CommonRequest request = new CommonRequest();
        request.setCmd("xx");
        Map<String, Object> map = new HashMap<>();
        map.put("11", "11");
        map.put("22", "22");
        request.setParams(map);
        List<Object[]> list = new ArrayList<>();
        Integer[] i = {1, 2, 4, 5};
        list.add(i);
        request.setList(list);
        String s = mapper.writeValueAsString(request);
        System.out.println(s);
    }


    @Test
    public void test() throws IOException {
       /* DrivingFingerprintIndexMatchResponse response = new DrivingFingerprintIndexMatchResponse();
        response.setCmd("baidu");
        response.setPageNo(1);
        response.setResultNote("SUCCESS");
        response.setTotalRecordNum(1);
        response.setPageNo(11);
        response.setPages(77);
        Detail detail = new Detail();
        DrivingFingerprintIndexMatch indexMatch = new DrivingFingerprintIndexMatch();
        indexMatch.setTrackId("11111111111");

        List<DrivingFingerprintIndexMatch> list = Arrays.asList(indexMatch);
        detail.setDataList(list);
        response.setDetail(detail);

        String s = mapper.writeValueAsString(response);
        System.out.println(s);

        DrivingFingerprintIndexMatchResponse response1 = mapper.readValue(s, DrivingFingerprintIndexMatchResponse.class);
        System.out.println(response1);*/
    }

    @Test
    public void test7() throws IOException {
        String json = "{\"cmd\":\"getDrivingFingerprintIndexMatch\",\"result\":0,\"resultNote\":\"SUCCESS\",\"totalRecordNum\":1,\"pages\":1,\"pageNo\":1,\"detail\":{\"dataList\":[{\"trackId\":\"000000C1AB10E091F1739560C80D0042\",\"objId\":\"14061313504297296\",\"deviceId\":\"YY2012521173\",\"mileage\":6306,\"fuel\":786,\"speed\":35,\"trackTime\":651,\"startTime\":\"2017-02-22 10:26:11\",\"endTime\":\"2017-02-22 10:37:02\",\"avgFuel\":12.46,\"overspeedNum\":0,\"accNum\":0,\"decNum\":0,\"turnNum\":0,\"brakesNum\":0,\"fuelScore\":0.0,\"overspeedScore\":14.0,\"accScore\":14.0,\"decScore\":14.0,\"turnScore\":14.0,\"brakeScore\":14.0,\"matchScore\":70.0,\"matchDate\":\"2017-02-22 00:00:00\",\"recordTime\":\"2017-03-30 09:58:50\"}]}}";
        DrivingFingerprintIndexMatchResponse drivingFingerprintIndexMatchResponse = mapper.readValue(json, DrivingFingerprintIndexMatchResponse.class);
        System.out.println(drivingFingerprintIndexMatchResponse);
    }


    @Test
    public void test8() throws IOException {

        String str = "46001234567891011";
        System.out.println(str.substring(0,3));
        System.out.println(str.substring(3,4));
        System.out.println(str.substring(4));
    }





}
