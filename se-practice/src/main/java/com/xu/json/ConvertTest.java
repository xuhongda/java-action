package com.xu.json;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        User user = new User();
        Girl girl = new Girl();
        List<Girl> girls = new ArrayList<>();
        girls.add(girl);
        user.setGirls(girls);
        mapper.writeValue(writer, user);
        log.info(writer.toString());
        Result<User> result = new Result<>();
        result.setData(user);
    }
}
