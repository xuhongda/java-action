package com.xu.serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import com.xu.pojo.Girl;
import org.dom4j.Document;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * @author xuhongda on 2018/11/5
 * com.xu.serializable
 * javase-practice
 */
@Test
public class SerTest {
    @Test
    public void test() throws IOException {
        Girl girl = new Girl();
        girl.setWeight(48.9);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(girl);
        System.out.println(s);

    }

    /**
     * <p>
     * 序列化与反序列化
     * transient 关键字
     *
     * </p>
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @org.junit.Test
    public void test2() throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("t.txt");
        Girl girl = new Girl();
        girl.setWeight(48.9);
        girl.setAge(18);
        girl.setName("yan");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(girl);
        outputStream.close();

        File f = new File("t.txt");
        FileInputStream fileInputStream = new FileInputStream(f);

        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Girl g = (Girl) inputStream.readObject();
        System.out.println(g);
    }
}
