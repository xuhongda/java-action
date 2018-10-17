package com.xu.lambda.book;

import com.google.common.base.Function;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

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
        assert hiddenFiles != null;
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
        //创建了一个方法的引用，可以传递它
        FileFilter isHidden = File::isHidden;
        File[] hiddenFiles = new File("C:\\Program Files").listFiles(isHidden);
        assert hiddenFiles != null;
        System.out.println(hiddenFiles.length);
        List<File> files = Arrays.asList(hiddenFiles);
        files.forEach(System.out::println);
    }
}
