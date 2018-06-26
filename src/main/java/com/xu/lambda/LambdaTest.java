package com.xu.lambda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @author xuhongda on 2018/6/18
 * com.xu.lambda
 * javase-practice
 */
public class LambdaTest {
    @Test
    public void test1(){
        File[] hiddenFiles1 = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
    }
}
