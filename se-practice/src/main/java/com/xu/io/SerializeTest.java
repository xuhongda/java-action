package com.xu.io;

import org.junit.Test;
import pojo.Girl;
import java.io.*;

/**
 * @author xuhongda on 2019/6/19
 * com.xu.io
 * java-action
 */
public class SerializeTest {


    @Test
    public void se001() throws IOException {
        Girl girl = new Girl("yan", 18, 50.50);
        //序列化
        FileOutputStream outputStream = new FileOutputStream("acc.text");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(girl);
    }


    @Test
    public void se00x() throws IOException, ClassNotFoundException {
        //反序列化
        ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream("acc.text"));
        Girl girl = (Girl) outputStream.readObject();
        System.out.println(girl);
    }

    @Test
    public void se002() throws IOException {

        File file = new File("acc.text");
        boolean exists = file.exists();
        if (exists) {
            //序列化
            // FileOutputStream outputStream = new FileOutputStream("acc.text");
            FileInputStream inputStream = new FileInputStream("acc.text");
            FileOutputStream objectOutputStream = new FileOutputStream("bcc.text");
            ObjectOutputStream outputStream = new ObjectOutputStream(objectOutputStream);
            int read = inputStream.read();
            System.out.println(read);
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read()) != -1) {
                outputStream.write(b, 0, len);
                // objectOutputStream.write(b,0,len);
            }
            outputStream.flush();
        }

    }
}
