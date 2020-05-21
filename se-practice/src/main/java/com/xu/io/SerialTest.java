package com.xu.io;

import org.junit.Test;
import pojo.Girl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuhongda on 2019/6/19
 * com.xu.io
 * java-action
 */
public class SerialTest {


    @Test
    public void se001() throws IOException {

        Girl girl = new Girl("xuhongda",18,50.50);
        //序列化
        FileOutputStream outputStream = new FileOutputStream("acc.text");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(girl);
    }

    @Test
    public void se002() throws IOException {

        File file = new File("acc.text");
        boolean exists = file.exists();
        if (exists){
            //序列化
           // FileOutputStream outputStream = new FileOutputStream("acc.text");
            FileInputStream inputStream = new FileInputStream("acc.text");
            FileOutputStream objectOutputStream = new FileOutputStream("bcc.text");
            ObjectOutputStream outputStream = new ObjectOutputStream(objectOutputStream);
            int read = inputStream.read();
            System.out.println(read);
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read()) != -1){
                outputStream.write(b,0,len);
               // objectOutputStream.write(b,0,len);
            }
            outputStream.flush();
        }

    }


    @Test
    public void test019() throws ParseException {


        String t = "2019-10-17";
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format2.parse(t);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(parse);

        System.out.println(format1);
    }
}
