package com.xu.exception.test;

import com.xu.exception.MyException;
import com.xu.exception.MyRunException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author xuhongda on 2020/11/27
 * com.xu.exception.test
 * java-action
 */
@Slf4j
public class ExceptionTest {

    @Test
    public void test001() {

        try {
            throw new MyRunException("this is my runtime exception");
        } catch (MyRunException e) {
            log.info(e.toString());
        }

    }


    @Test
    public void test002() {
        try {
            throw new MyException("this is my  exception");
        } catch (MyException e) {
            log.info("e = ",e);
        }
    }


    @Test
    public void test003() {
        ex1();
        try {
            ex2();
        } catch (Exception e) {
            log.info("ex2= {}", e.toString());
        } finally {
            log.info("...");
        }
    }


    private void ex1() throws MyRunException {
        throw new MyRunException("this is my runtime exception");
    }


    private void ex2() throws MyException {
        throw new MyException("this is my exception");
    }
}
