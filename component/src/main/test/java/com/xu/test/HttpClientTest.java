package com.xu.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/7/10
 * com.xu.test
 * java-action
 */
@Slf4j
public class HttpClientTest {


    public static void main(String[] args) throws Exception {
        test001();
    }


    private static void  test001() throws InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<String> list = new ArrayList<>();
        executorService.submit(()->{
            list.add("thread 1");

            log.info("{}",Thread.currentThread().getName());
            for (long i = 0;i<9;i++){
                HttpGet get = new HttpGet("http://129.204.79.247/xu7x/indexs?pageNum=1&pageSize=2");
                HttpGet get2 = new HttpGet("http://129.204.79.247/xu7x/content?id=2");
                CloseableHttpClient build = HttpClientBuilder.create().build();

                try {
                    build.execute(get);
                    build.execute(get2);
                } catch (IOException e) {
                    log.info(e.toString());
                    executorService.shutdown();
                    break;
                }
            }
        });

        executorService.submit(()-> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("thread 2");
            log.info("The other thread = {} to do other tasks",Thread.currentThread().getName());
        });

        executorService.submit(()-> log.info(String.valueOf(list.size()))
        );
    }
}
