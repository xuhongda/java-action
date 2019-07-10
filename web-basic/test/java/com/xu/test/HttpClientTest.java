package com.xu.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/7/10
 * com.xu.test
 * java-action
 */
@Slf4j
public class HttpClientTest {

    @Test
    public void  test() throws IOException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(()-> System.out.println("xx"));

        for (int j = 0; j <9; j++) {
            executorService.submit(()->{
                for (long i = 0;i<9;i++){
                    HttpGet get = new HttpGet("http://129.204.79.247/xu7x/indexs?pageNum=1&pageSize=2");
                    HttpGet get2 = new HttpGet("http://129.204.79.247/xu7x/content?id=2");
                    CloseableHttpClient build = HttpClientBuilder.create().build();
                    try {
                        CloseableHttpResponse execute = build.execute(get);
                        build.execute(get2);
                        log.info("{},{}",Thread.currentThread().getName(),execute.getEntity().toString());
                        //Thread.sleep(2000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        boolean terminated = executorService.isTerminated();



        while (!terminated){
            executorService.shutdown();
        }


    }
}
