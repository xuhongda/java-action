package com.xu.lambda.book;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * 筛选一个目录中的所有隐藏
 * 文件
 * @author xuhongda on 2018/6/18
 * com.xu.lambda
 * javase-practice
 */
public class FileHiddenTest {
    /**
     * 原始写法
     */
    @Test
    public void test1(){
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        System.out.println(hiddenFiles.length);
        for(File file : hiddenFiles){
            System.out.println(file.getName());
        }
    }

    /**
     * java 8 把方法当参数
     */
    @Test
    public void test2(){
        File[] hiddenFiles = new File("C:\\Program Files").listFiles(File::isHidden);
        System.out.println(hiddenFiles.length);
        for(File file : hiddenFiles){
            System.out.println(file.getName());
        }
    }
}
