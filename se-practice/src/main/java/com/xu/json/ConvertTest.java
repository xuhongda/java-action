package com.xu.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.Girl;
import pojo.Result;
import pojo.User;

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
}
